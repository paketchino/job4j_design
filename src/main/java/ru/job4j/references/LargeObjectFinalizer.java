package ru.job4j.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class LargeObjectFinalizer extends PhantomReference<Object> {

    ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
    List<LargeObjectFinalizer> references = new ArrayList<>();
    List<Object> largeObjects = new ArrayList<>();

    /**
     * Creates a new phantom reference that refers to the given object and
     * is registered with the given queue.
     *
     * <p> It is possible to create a phantom reference with a {@code null}
     * queue, but such a reference is completely useless: Its {@code get}
     * method will always return {@code null} and, since it does not have a queue,
     * it will never be enqueued.
     *
     * @param referent the object the new phantom reference will refer to
     * @param q        the queue with which the reference is to be registered,
     *                 or {@code null} if registration is not required
     */
    public LargeObjectFinalizer(Object referent, ReferenceQueue<? super Object> q) {
        super(referent, q);
    }

    public void finalizeResources() {
        System.out.println("Cleaning");
    }

    public void cleaning() {
        for (int i = 0; i < 10; i++) {
            Object largeObject = new Object();
            largeObjects.add(largeObject);
            references.add(new LargeObjectFinalizer(largeObject, referenceQueue));
        }
        largeObjects = null;
        System.gc();

        Reference<?> referenceFromQueue;
        for (PhantomReference<Object> reference : references) {
            System.out.println(reference.isEnqueued());
        }

        while ((referenceFromQueue = referenceQueue.poll()) != null) {
            ((LargeObjectFinalizer) referenceFromQueue).finalizeResources();
            referenceFromQueue.clear();
        }
    }
}

// Generated by jextract

package libpg_query.v15;

import java.lang.invoke.*;
import java.lang.foreign.*;
import java.nio.ByteOrder;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.PathElement.*;

/**
 * {@snippet lang=c :
 * struct __pthread_internal_list {
 *     struct __pthread_internal_list *__prev;
 *     struct __pthread_internal_list *__next;
 * }
 * }
 */
public class __pthread_internal_list {

    __pthread_internal_list() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        pg_query_h.C_POINTER.withName("__prev"),
        pg_query_h.C_POINTER.withName("__next")
    ).withName("__pthread_internal_list");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final AddressLayout __prev$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("__prev"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * struct __pthread_internal_list *__prev
     * }
     */
    public static final AddressLayout __prev$layout() {
        return __prev$LAYOUT;
    }

    private static final long __prev$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * struct __pthread_internal_list *__prev
     * }
     */
    public static final long __prev$offset() {
        return __prev$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * struct __pthread_internal_list *__prev
     * }
     */
    public static MemorySegment __prev(MemorySegment struct) {
        return struct.get(__prev$LAYOUT, __prev$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * struct __pthread_internal_list *__prev
     * }
     */
    public static void __prev(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(__prev$LAYOUT, __prev$OFFSET, fieldValue);
    }

    private static final AddressLayout __next$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("__next"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * struct __pthread_internal_list *__next
     * }
     */
    public static final AddressLayout __next$layout() {
        return __next$LAYOUT;
    }

    private static final long __next$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * struct __pthread_internal_list *__next
     * }
     */
    public static final long __next$offset() {
        return __next$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * struct __pthread_internal_list *__next
     * }
     */
    public static MemorySegment __next(MemorySegment struct) {
        return struct.get(__next$LAYOUT, __next$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * struct __pthread_internal_list *__next
     * }
     */
    public static void __next(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(__next$LAYOUT, __next$OFFSET, fieldValue);
    }

    /**
     * Obtains a slice of {@code arrayParam} which selects the array element at {@code index}.
     * The returned segment has address {@code arrayParam.address() + index * layout().byteSize()}
     */
    public static MemorySegment asSlice(MemorySegment array, long index) {
        return array.asSlice(layout().byteSize() * index);
    }

    /**
     * The size (in bytes) of this struct
     */
    public static long sizeof() { return layout().byteSize(); }

    /**
     * Allocate a segment of size {@code layout().byteSize()} using {@code allocator}
     */
    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout());
    }

    /**
     * Allocate an array of size {@code elementCount} using {@code allocator}.
     * The returned segment has size {@code elementCount * layout().byteSize()}.
     */
    public static MemorySegment allocateArray(long elementCount, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(elementCount, layout()));
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, Arena arena, Consumer<MemorySegment> cleanup) {
        return reinterpret(addr, 1, arena, cleanup);
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code elementCount * layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, long elementCount, Arena arena, Consumer<MemorySegment> cleanup) {
        return addr.reinterpret(layout().byteSize() * elementCount, arena, cleanup);
    }
}


// Generated by jextract

package libpg_query.v16;

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
 * struct {
 *     char *query;
 *     PgQueryError *error;
 * }
 * }
 */
public class PgQueryDeparseResult {

    PgQueryDeparseResult() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        pg_query_h.C_POINTER.withName("query"),
        pg_query_h.C_POINTER.withName("error")
    ).withName("$anon$51:9");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final AddressLayout query$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("query"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * char *query
     * }
     */
    public static final AddressLayout query$layout() {
        return query$LAYOUT;
    }

    private static final long query$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * char *query
     * }
     */
    public static final long query$offset() {
        return query$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * char *query
     * }
     */
    public static MemorySegment query(MemorySegment struct) {
        return struct.get(query$LAYOUT, query$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * char *query
     * }
     */
    public static void query(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(query$LAYOUT, query$OFFSET, fieldValue);
    }

    private static final AddressLayout error$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("error"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * PgQueryError *error
     * }
     */
    public static final AddressLayout error$layout() {
        return error$LAYOUT;
    }

    private static final long error$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * PgQueryError *error
     * }
     */
    public static final long error$offset() {
        return error$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * PgQueryError *error
     * }
     */
    public static MemorySegment error(MemorySegment struct) {
        return struct.get(error$LAYOUT, error$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * PgQueryError *error
     * }
     */
    public static void error(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(error$LAYOUT, error$OFFSET, fieldValue);
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


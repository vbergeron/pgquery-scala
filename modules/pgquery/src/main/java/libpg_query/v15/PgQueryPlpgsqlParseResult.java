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
 * struct {
 *     char *plpgsql_funcs;
 *     PgQueryError *error;
 * }
 * }
 */
public class PgQueryPlpgsqlParseResult {

    PgQueryPlpgsqlParseResult() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        pg_query_h.C_POINTER.withName("plpgsql_funcs"),
        pg_query_h.C_POINTER.withName("error")
    ).withName("$anon$56:9");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final AddressLayout plpgsql_funcs$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("plpgsql_funcs"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * char *plpgsql_funcs
     * }
     */
    public static final AddressLayout plpgsql_funcs$layout() {
        return plpgsql_funcs$LAYOUT;
    }

    private static final long plpgsql_funcs$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * char *plpgsql_funcs
     * }
     */
    public static final long plpgsql_funcs$offset() {
        return plpgsql_funcs$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * char *plpgsql_funcs
     * }
     */
    public static MemorySegment plpgsql_funcs(MemorySegment struct) {
        return struct.get(plpgsql_funcs$LAYOUT, plpgsql_funcs$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * char *plpgsql_funcs
     * }
     */
    public static void plpgsql_funcs(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(plpgsql_funcs$LAYOUT, plpgsql_funcs$OFFSET, fieldValue);
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


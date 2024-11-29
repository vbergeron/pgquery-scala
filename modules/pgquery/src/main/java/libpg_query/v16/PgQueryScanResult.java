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
 *     PgQueryProtobuf pbuf;
 *     char *stderr_buffer;
 *     PgQueryError *error;
 * }
 * }
 */
public class PgQueryScanResult {

    PgQueryScanResult() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        PgQueryProtobuf.layout().withName("pbuf"),
        pg_query_h.C_POINTER.withName("stderr_buffer"),
        pg_query_h.C_POINTER.withName("error")
    ).withName("$anon$21:9");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final GroupLayout pbuf$LAYOUT = (GroupLayout)$LAYOUT.select(groupElement("pbuf"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * PgQueryProtobuf pbuf
     * }
     */
    public static final GroupLayout pbuf$layout() {
        return pbuf$LAYOUT;
    }

    private static final long pbuf$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * PgQueryProtobuf pbuf
     * }
     */
    public static final long pbuf$offset() {
        return pbuf$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * PgQueryProtobuf pbuf
     * }
     */
    public static MemorySegment pbuf(MemorySegment struct) {
        return struct.asSlice(pbuf$OFFSET, pbuf$LAYOUT.byteSize());
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * PgQueryProtobuf pbuf
     * }
     */
    public static void pbuf(MemorySegment struct, MemorySegment fieldValue) {
        MemorySegment.copy(fieldValue, 0L, struct, pbuf$OFFSET, pbuf$LAYOUT.byteSize());
    }

    private static final AddressLayout stderr_buffer$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("stderr_buffer"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * char *stderr_buffer
     * }
     */
    public static final AddressLayout stderr_buffer$layout() {
        return stderr_buffer$LAYOUT;
    }

    private static final long stderr_buffer$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * char *stderr_buffer
     * }
     */
    public static final long stderr_buffer$offset() {
        return stderr_buffer$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * char *stderr_buffer
     * }
     */
    public static MemorySegment stderr_buffer(MemorySegment struct) {
        return struct.get(stderr_buffer$LAYOUT, stderr_buffer$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * char *stderr_buffer
     * }
     */
    public static void stderr_buffer(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(stderr_buffer$LAYOUT, stderr_buffer$OFFSET, fieldValue);
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

    private static final long error$OFFSET = 24;

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


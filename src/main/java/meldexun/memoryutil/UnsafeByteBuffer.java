package meldexun.memoryutil;

import java.nio.ByteBuffer;

public class UnsafeByteBuffer extends UnsafeNIOBuffer<ByteBuffer> {

	public UnsafeByteBuffer(long address, long capacity) {
		super(address, capacity);
	}

	public long getByteCapacity() {
		return getCapacity();
	}

	@Override
	protected ByteBuffer createBuffer() {
		return NIOBufferUtil.asByteBuffer(getAddress(), getByteCapacity());
	}

}

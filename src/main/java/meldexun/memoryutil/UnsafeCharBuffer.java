package meldexun.memoryutil;

import java.nio.CharBuffer;

public class UnsafeCharBuffer extends UnsafeNIOBuffer<CharBuffer> {

	public UnsafeCharBuffer(long address, long capacity) {
		super(address, PrimitiveInfo.CHAR.toByte(capacity));
	}

	public long getCharCapacity() {
		return PrimitiveInfo.CHAR.fromByte(getCapacity());
	}

	@Override
	protected CharBuffer createBuffer() {
		return NIOBufferUtil.asCharBuffer(getAddress(), getCharCapacity());
	}

}

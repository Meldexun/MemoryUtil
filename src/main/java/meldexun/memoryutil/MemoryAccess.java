package meldexun.memoryutil;

import static meldexun.memoryutil.UnsafeUtil.UNSAFE;

import java.util.Objects;

import sun.misc.Unsafe;

public interface MemoryAccess {

	static MemoryAccess of(long address) {
		return (SingleRegister) () -> address;
	}

	static MemoryAccess of(Object object, long offset) {
		Objects.requireNonNull(object);
		return new DoubleRegister() {
			@Override
			public Object getObject() {
				return object;
			}

			@Override
			public long getAddress() {
				return offset;
			}
		};
	}

	static MemoryAccess of(boolean[] array) {
		return of(array, Unsafe.ARRAY_BOOLEAN_BASE_OFFSET);
	}

	static MemoryAccess of(byte[] array) {
		return of(array, Unsafe.ARRAY_BYTE_BASE_OFFSET);
	}

	static MemoryAccess of(short[] array) {
		return of(array, Unsafe.ARRAY_SHORT_BASE_OFFSET);
	}

	static MemoryAccess of(int[] array) {
		return of(array, Unsafe.ARRAY_INT_BASE_OFFSET);
	}

	static MemoryAccess of(long[] array) {
		return of(array, Unsafe.ARRAY_LONG_BASE_OFFSET);
	}

	static MemoryAccess of(float[] array) {
		return of(array, Unsafe.ARRAY_FLOAT_BASE_OFFSET);
	}

	static MemoryAccess of(double[] array) {
		return of(array, Unsafe.ARRAY_DOUBLE_BASE_OFFSET);
	}

	static MemoryAccess of(char[] array) {
		return of(array, Unsafe.ARRAY_CHAR_BASE_OFFSET);
	}

	static void copyMemory(MemoryAccess src, long srcOffset, MemoryAccess dest, long destOffset, long bytes) {
		MemoryUtil.copyMemory(src.getObject(), src.getAddress() + srcOffset, dest.getObject(), dest.getAddress() + destOffset, bytes);
	}

	Object getObject();

	long getAddress();

	boolean getBoolean(long offset);

	void putBoolean(long offset, boolean data);

	byte getByte(long offset);

	void putByte(long offset, byte data);

	short getShort(long offset);

	void putShort(long offset, short data);

	int getInt(long offset);

	void putInt(long offset, int data);

	long getLong(long offset);

	void putLong(long offset, long data);

	float getFloat(long offset);

	void putFloat(long offset, float data);

	double getDouble(long offset);

	void putDouble(long offset, double data);

	char getChar(long offset);

	void putChar(long offset, char data);

	interface SingleRegister extends MemoryAccess {

		@Override
		default Object getObject() {
			return null;
		}

		@Override
		default boolean getBoolean(long offset) {
			return UNSAFE.getBoolean(null, getAddress() + offset);
		}

		@Override
		default void putBoolean(long offset, boolean data) {
			UNSAFE.putBoolean(null, getAddress() + offset, data);
		}

		@Override
		default byte getByte(long offset) {
			return UNSAFE.getByte(getAddress() + offset);
		}

		@Override
		default void putByte(long offset, byte data) {
			UNSAFE.putByte(getAddress() + offset, data);
		}

		@Override
		default short getShort(long offset) {
			return UNSAFE.getShort(getAddress() + offset);
		}

		@Override
		default void putShort(long offset, short data) {
			UNSAFE.putShort(getAddress() + offset, data);
		}

		@Override
		default int getInt(long offset) {
			return UNSAFE.getInt(getAddress() + offset);
		}

		@Override
		default void putInt(long offset, int data) {
			UNSAFE.putInt(getAddress() + offset, data);
		}

		@Override
		default long getLong(long offset) {
			return UNSAFE.getLong(getAddress() + offset);
		}

		@Override
		default void putLong(long offset, long data) {
			UNSAFE.putLong(getAddress() + offset, data);
		}

		@Override
		default float getFloat(long offset) {
			return UNSAFE.getFloat(getAddress() + offset);
		}

		@Override
		default void putFloat(long offset, float data) {
			UNSAFE.putFloat(getAddress() + offset, data);
		}

		@Override
		default double getDouble(long offset) {
			return UNSAFE.getDouble(getAddress() + offset);
		}

		@Override
		default void putDouble(long offset, double data) {
			UNSAFE.putDouble(getAddress() + offset, data);
		}

		@Override
		default char getChar(long offset) {
			return UNSAFE.getChar(getAddress() + offset);
		}

		@Override
		default void putChar(long offset, char data) {
			UNSAFE.putChar(getAddress() + offset, data);
		}

	}

	interface DoubleRegister extends MemoryAccess {

		@Override
		default boolean getBoolean(long offset) {
			return UNSAFE.getBoolean(getObject(), getAddress() + offset);
		}

		@Override
		default void putBoolean(long offset, boolean data) {
			UNSAFE.putBoolean(getObject(), getAddress() + offset, data);
		}

		@Override
		default byte getByte(long offset) {
			return UNSAFE.getByte(getObject(), getAddress() + offset);
		}

		@Override
		default void putByte(long offset, byte data) {
			UNSAFE.putByte(getObject(), getAddress() + offset, data);
		}

		@Override
		default short getShort(long offset) {
			return UNSAFE.getShort(getObject(), getAddress() + offset);
		}

		@Override
		default void putShort(long offset, short data) {
			UNSAFE.putShort(getObject(), getAddress() + offset, data);
		}

		@Override
		default int getInt(long offset) {
			return UNSAFE.getInt(getObject(), getAddress() + offset);
		}

		@Override
		default void putInt(long offset, int data) {
			UNSAFE.putInt(getObject(), getAddress() + offset, data);
		}

		@Override
		default long getLong(long offset) {
			return UNSAFE.getLong(getObject(), getAddress() + offset);
		}

		@Override
		default void putLong(long offset, long data) {
			UNSAFE.putLong(getObject(), getAddress() + offset, data);
		}

		@Override
		default float getFloat(long offset) {
			return UNSAFE.getFloat(getObject(), getAddress() + offset);
		}

		@Override
		default void putFloat(long offset, float data) {
			UNSAFE.putFloat(getObject(), getAddress() + offset, data);
		}

		@Override
		default double getDouble(long offset) {
			return UNSAFE.getDouble(getObject(), getAddress() + offset);
		}

		@Override
		default void putDouble(long offset, double data) {
			UNSAFE.putDouble(getObject(), getAddress() + offset, data);
		}

		@Override
		default char getChar(long offset) {
			return UNSAFE.getChar(getObject(), getAddress() + offset);
		}

		@Override
		default void putChar(long offset, char data) {
			UNSAFE.putChar(getObject(), getAddress() + offset, data);
		}

	}

}

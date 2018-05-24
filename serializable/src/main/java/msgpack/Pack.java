package msgpack;

import java.io.IOException;

import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;

public abstract class Pack {
	
	public int dataType; // ※ 필수 

	public void packString(MessageBufferPacker packer,String str) throws IOException {
		if(str == null) {
			packer.packNil();
		} else {
			packer.packString(str);
		}
	}
	
	public String unpackString(MessageUnpacker unPacker) throws IOException {
		if(unPacker.tryUnpackNil()) {
			return null;
		} else {
			return unPacker.unpackString();
		}
	}
	
	public Pack unPack(byte[] bytes) {
		
		Pack pack = null;
		
		try {
		
			MessageUnpacker unPacker = MessagePack.newDefaultUnpacker(bytes);
			this.dataType 			 = unPacker.unpackByte();
			pack = read(unPacker);
			unPacker.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pack;
	}
	
	public byte[] toByteArray() {

		try {
		
			MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
			packer.packInt(dataType);
			write(packer);
			packer.close();
			
			return packer.toByteArray();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	abstract Pack read(MessageUnpacker unPacker);
	
	abstract MessageBufferPacker write(MessageBufferPacker packer);
}

package msgpack;

import java.io.IOException;

import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessageUnpacker;

public class TransXviewPack extends Pack {

	public String aid;
	public String gid;
	public long txid;
	public long sTime;
	public long eTime;
	public int elapsed;
	public int serv_h;
    public int uagent_h;
    public int qst_h;    
	public int sql_t;
	public int sql_c;
	public int fetch_c;
	public int cpu_t;
	public int bytes;
	public String l_ip;
	public String r_ip;
	public String method;
	public int ref_h;	
	public int e;
	public int e_cls;
	public byte e_g;
	public int uid;



	@Override
	TransXviewPack read(MessageUnpacker unPacker) {

		try {
		
			this.aid 			= unpackString(unPacker);
			this.gid 			= unpackString(unPacker);
			this.txid 			= unPacker.unpackLong();
			this.sTime 			= unPacker.unpackLong();
			this.eTime 			= unPacker.unpackLong();
			this.elapsed 		= unPacker.unpackInt();
			this.serv_h 		= unPacker.unpackInt();
			this.uagent_h 		= unPacker.unpackInt();
			this.qst_h 			= unPacker.unpackInt();
			this.sql_t 			= unPacker.unpackInt();
			this.sql_c 			= unPacker.unpackInt();
			this.fetch_c 		= unPacker.unpackInt();
			this.cpu_t 			= unPacker.unpackInt();		
			this.bytes 			= unPacker.unpackInt();		
			this.l_ip			= unpackString(unPacker);
			this.r_ip 			= unpackString(unPacker);
			this.method			= unpackString(unPacker);
			this.ref_h 			= unPacker.unpackInt();
			this.e 				= unPacker.unpackInt();
			this.e_cls 			= unPacker.unpackInt();
			this.e_g 			= unPacker.unpackByte();
			this.uid 			= unPacker.unpackInt();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
		
	}


	@Override
	MessageBufferPacker write(MessageBufferPacker packer) {
		
		try {
			packString(packer, aid);
			packString(packer, gid);
			packer.packLong(txid);
			packer.packLong(sTime);
			packer.packLong(eTime);
			packer.packInt(elapsed);
			packer.packInt(serv_h);
			packer.packInt(uagent_h);
			packer.packInt(qst_h);
			packer.packInt(sql_t);
			packer.packInt(sql_c);
			packer.packInt(fetch_c);
			packer.packInt(cpu_t);
			packer.packInt(bytes);
			packString(packer, l_ip);
			packString(packer, r_ip);
			packString(packer, method);
			packer.packInt(ref_h);
			packer.packInt(e);
			packer.packInt(e_cls);
			packer.packByte(e_g);
			packer.packInt(uid);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return packer;
		
	}
	
	
}

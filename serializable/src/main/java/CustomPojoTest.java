import custom.DataType;
import custom.TransXviewPack;

public class CustomPojoTest {

	public static int loop = 1000000;
	
	public static void main(String[] args) {
		
		long sTime = System.currentTimeMillis();
		long eTime = System.currentTimeMillis();
		
		long byteLength = 0;

		for (int i = 0; i < loop; i++) {

			TransXviewPack xviewpack = new TransXviewPack();
			xviewpack.dataType = DataType.SAMPLE;
			xviewpack.txid = -4036160422503608319L;			
			xviewpack.serv_h=28171712;
			xviewpack.uagent_h=-28171722;
			xviewpack.qst_h=-2817172;
			xviewpack.aid="a15";
			xviewpack.sql_t=166;
			xviewpack.sql_c=50;
			xviewpack.fetch_c = 1234;
			xviewpack.cpu_t =  1466;
			xviewpack.l_ip="127.0.0.1";
			xviewpack.r_ip = "121.169.21.115";
			xviewpack.method = "GET";
			xviewpack.ref_h = 18171722;
			xviewpack.sTime = sTime;
			xviewpack.eTime = eTime;
			xviewpack.elapsed = 1234;
			xviewpack.gid = "1";	
			xviewpack.e = -1;
			xviewpack.e_cls = 1;
			xviewpack.e_g  = 1;
			xviewpack.uid = 1823;
			xviewpack.bytes = 1823;
	
			byteLength += xviewpack.toByteArray().length;
//			System.out.println("######### byte length => " + xbytess.length);
		}
		
		System.out.println("ProtobufTest byte length => " + byteLength);		
		System.out.println("CustomPojoTest elapsed => " + (System.currentTimeMillis() - sTime));
	}
}

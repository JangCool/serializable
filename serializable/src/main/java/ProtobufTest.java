import custom.DataType;

public class ProtobufTest {

	
	public static void main(String[] args) {
		
		long sTime = System.currentTimeMillis();
		long eTime = System.currentTimeMillis();
		
		long byteLength = 0;

		for (int i = 0; i < CustomPojoTest.loop ; i++) {
			protobuf.TransXviewPackBuilder.TransXviewPack builder = protobuf.TransXviewPackBuilder.TransXviewPack.newBuilder()
					.setDataType(DataType.SAMPLE)
					.setTxid(-4036160422503608319L)
					.setServH(28171712)
					.setUagentH(-28171722) // ID 
					.setQstH(-2817172)
					.setAid("a15")				 // NAME
					.setSqlT(166)
					.setSqlC(50)
					.setFetchC(1234)
					.setCpuT(1466)
					.setLIp("127.0.0.1")
					.setRIp("121.169.21.115")
					.setMethod("GET")
					.setRefH(18171722)
					.setSTime(sTime)
					.setETime(eTime)
					.setElapsed(1234)
					.setGid("1")
					.setErr(-1)
					.setErrCls(1)
					.setErrG(1)
					.setUid(1823)
					.setBytes(1823)
					.build();	
			byteLength += builder.toByteArray().length;

		}
		
		System.out.println("ProtobufTest byte length => " + byteLength);		
		System.out.println("ProtobufTest elapsed => " + (System.currentTimeMillis() - sTime));

	}
	
}

package pkubatis.toolkit;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;

public class PwVerifyUtil {

	private static byte[] digest(MessageDigest digest,byte[] data,byte[] salt,int hashIterations){
		if(salt != null){
			digest.reset();
			digest.update(salt);
		}
		byte[] hashed = digest.digest(data);
		for(int i=1;i<hashIterations;i++){
			digest.reset();
			hashed = digest.digest(hashed);
		}
		return hashed;
	}

	public static String md5Hex(String data,String salt,int iter){
		return Hex.encodeHexString(
				digest(DigestUtils.getSha1Digest(),StringUtils.getBytesUtf8(data)
						,StringUtils.getBytesUtf8(salt),iter));
	}

	public static void main(String[] args) {
		System.out.println(md5Hex("123456","st_sz_20201",1024));
	}
}

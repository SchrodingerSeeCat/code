import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class Main {
    public static void main(String[] main) throws Exception {

        String input = "待加密的对象";

        String algorithm = "RSA";

        // 创建密钥对生成器对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);

        // 生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // 生成公钥和私钥
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // 获取私钥和公钥的字节数组
        byte[] privateEncoded = privateKey.getEncoded();
        byte[] publicEncoded = publicKey.getEncoded();

        // 使用Base64编码
        Base64.Encoder encoder = Base64.getEncoder();

        // System.out.println(encoder.encodeToString(privateEncoded));
        // System.out.println(encoder.encodeToString(publicEncoded));

        // 创建加密对象
        Cipher clipher = Cipher.getInstance(algorithm);
        // 对加密进行初始化
        // 加密模式 公钥加密还是私钥加密 
        clipher.init(Cipher.ENCRYPT_MODE, privateKey);

        // 得到加密后的字节数组
        byte[] bytes1 = clipher.doFinal(input.getBytes());
        System.out.println(encoder.encodeToString(bytes1));

        // 私钥解密
        clipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] bytes2 = clipher.doFinal(bytes1);
        System.out.println(new String(bytes2));

    }
}
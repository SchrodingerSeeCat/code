import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, String> headers = new HashMap<>();
        headers.put("cookie", "rpdid=|(umJJlR|uJu0J'uYu|)~|uRY; sid=4z1olq0i; DedeUserID=350829452; DedeUserID__ckMd5=0b97b242d9fbe089; SESSDATA=67024a5e,1626439519,45c1b*11; bili_jct=eda4d40b0be63fe292ce889e0a381f47; _uuid=FD91A46B-7750-B460-AA15-4573924A221E26498infoc; buvid3=AD912AE4-2E4A-41EB-8932-F0C8C036C5BB184996infoc; CURRENT_FNVAL=80; buvid_fp=AD912AE4-2E4A-41EB-8932-F0C8C036C5BB184996infoc; buvid_fp_plain=AD912AE4-2E4A-41EB-8932-F0C8C036C5BB184996infoc; LIVE_BUVID=AUTO7716124436039850; CURRENT_QUALITY=116; balh_server_inner=__custom__; balh_is_closed=; PVID=1; fingerprint3=89ac35915a343b9ef7a9ed6d22334b1c; fingerprint=c581c07b41e53098423032a2886e48a0; fingerprint_s=f5b2c874e7d2c54e725a049f54217074; bp_video_offset_350829452=494496451131808207; bp_article_offset_350829452=493327090445143884; bp_t_offset_350829452=494557650121144640; blackside_state=1; bfe_id=1e33d9ad1cb29251013800c68af42315");
        headers.put("referer", "https://www.bilibili.com");
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.182 Safari/537.36 Edg/88.0.705.74");

        String url ="https://www.bilibili.com/";
        Document document = Jsoup.connect(url).headers(headers).get();

        System.out.println(document);

        Elements elements = document.getElementsByTag("img");
        for(Element ele : elements) {
            System.out.println(ele.attr("src"));
        }
    }
}

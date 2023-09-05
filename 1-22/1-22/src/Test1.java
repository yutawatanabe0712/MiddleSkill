import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) {
		String shinyaBirthday = "1998/03/19";
		String minamiBirthday = "2000/02/14";
		String furuyamaBirthday = "1998/09/12";
		//改行
		System.out.println("問１");
		//問題1:現在の時刻を出力してください
		Date date = new Date();
		System.out.println(date);
		//改行
		System.out.println("問２");
		//問題2:shinyaBirthdayとminamiBirthdayを日付型に変更し条件式で誕生日を比較し早い方の日付を文字列型で出力しなさい。
		SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date shinya = sd.parse(shinyaBirthday);
			Date minami = sd.parse(minamiBirthday);
			if (shinya.before(minami)) {
				String sd2 = new SimpleDateFormat("yyyy/MM/dd").format(shinya);
				System.out.println(sd2);
			} else {
				String sd3 = new SimpleDateFormat("yyyy/MM/dd").format(minami);
				System.out.println(sd3);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//改行
		System.out.println("問３");
		//問題3:furuyamaBirthdayに５年2ヶ月追加した値を文字列型で表示しなさい
		try {
			Date furuyama = sd.parse(furuyamaBirthday);
			Calendar cal = Calendar.getInstance();
			cal.setTime(furuyama);
			cal.add(Calendar.YEAR, 5);
			cal.add(Calendar.MONTH, 2);
			Date furuyamaDay = cal.getTime();
			String sd4 = new SimpleDateFormat("yyyy/MM/dd").format(furuyamaDay);
			System.out.println(sd4.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

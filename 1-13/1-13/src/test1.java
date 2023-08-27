import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test1 {
	public static void main(String[] args) {
		//改行
		System.out.println("問１");
		//問題1:下記の条件を使ってfor文と条件文を組み合わせ結果が同じになるよう出力しなさい。for文ネスト3回（3回forを書くこと）
		//		例）
		//		for() {
		//			for() {
		//				for() {
		//
		//				}
		//			}
		//		}
		//strArray1でfor文を回し3文字目(k)以降のものをstrArray2に格納する(1個目のfor文)
		//strArray2でfor文を回しkとaとoの物だけでstrArray3に格納する(2個目のfor文)
		//strArray3でfor文を回し「kakao」となるようにstrArray4に格納しstrArray4を出力する。(3個目のfor文)
		List<String> strArray1 = new ArrayList(Arrays.asList("f", "u", "k", "u", "d", "a", "k", "a", "n", "e", "k", "o"));
		List<String> strArray2 = new ArrayList<String>();
		List<String> strArray3 = new ArrayList<String>();
		List<String> strArray4 = new ArrayList<String>();

		//strArray1でfor文を回し3文字目(k)以降のものをstrArray2に格納する(1個目のfor文)
		for (int i = 2; i < strArray1.size(); i++) {
			strArray2.add(strArray1.get(i));
			//strArray2でfor文を回しkとaとoの物だけでstrArray3に格納する(2個目のfor文)
			for (int n = i - 2; n < strArray2.size(); n++) {
				if (strArray2.get(n).equals("k") || strArray2.get(n).equals("a") || strArray2.get(n).equals("o")) {
					strArray3.add(strArray2.get(n));
					//strArray3でfor文を回し「kakao」となるようにstrArray4に格納しstrArray4を出力する。(3個目のfor文)
					if (i > 9) {
						for (int j = i - 6; j < 5; j++) {
							if (strArray3.get(j).equals("k")) {
								strArray3.remove(j);
								strArray4 = strArray3;
							}
						}
					}
				}
			}
		}
		System.out.println(strArray4);


	}
}

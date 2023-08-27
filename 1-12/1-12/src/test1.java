public class test1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//改行
		System.out.println("問１");
		//問題1:下記の条件を満たすようにif文を3つネストして条件式を作成してください。
		//
		//変数x,y,zは正の整数であれば下の条件に続く。それ以外は”正の整数：NG”と表示する
		//xの値が10の倍数であれば下の条件に続く。それ以外は”10の倍数：NG”と表示する
		//x + y + z = 100であれば”プラス100：OK”それ以外は”プラス100：NG”と表示する

		int x = 10;
		int y = 80;
		int z = 15;

		if (x > 0 && y > 0 && z > 0) {
			if (x % 10 == 0) {
				if (x + y + z == 100) {
					System.out.println("プラス100：OK");
				}else {
					System.out.println("プラス100：NG");
				}
			}else {
				System.out.println("10の倍数：NG");
			}
		}else {
			System.out.println("正の整数：NG");
		}

		//改行
		System.out.println("問２");
		//問題2:問1と同じ内容で三項演算子で条件式を作成しなさい。最後に変数aを出力する。
		String a = "";
		//正の整数：NGを判断
		a = (x > 0 && y > 0 && z > 0)?  "": "正の整数：NG";
		//"10の倍数：NG"を判断
		a = (a == "") && !(x % 10 == 0)? "10の倍数：NG" :a;
		//"10の倍数：OK"を判断
		a = (a == "") && (x % 10 == 0)? "" : a;
		//"プラス100：NG"を判断
		a = (a == "") && !(x + y + z == 100)? "プラス100：NG" : a;
		//"プラス100：OK"を判断
		a = (a == "") && (x + y + z == 100)? "プラス100：OK" : a;
		System.out.println(a);
	}
}

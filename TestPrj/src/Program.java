import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import com.newlecture.web.entity.Menu;

public class Program {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Menu menu = new Menu(0, null, 0, null);
		menu.setName("아메리카노");
		System.out.println(menu);
		
		FileInputStream fis = new FileInputStream("res/Setting.txt");
		Scanner scan = new Scanner(fis);
		
		String clsName = scan.nextLine();
		
		Menu menu1 = (Menu) Class.forName(clsName).newInstance();
		
		menu1.setName("카페라떼");
		System.out.println(menu1);
		
		scan.close();
		fis.close();
	}

}

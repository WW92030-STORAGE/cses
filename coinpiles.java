import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coinpiles { // coin piles 1754
	
	// DESCRIPTION
	// there are 2 piles of coins (pvz plushies). you remove one obj from one pile but 2 from the other
	// its only possible to get to 0 if the sum of the 2 piles mod 3 is 0 and both piles have cheezburgers or nothing at all
	// and that no pile is more than double the size of the other pile cuz sans is overrated
	public static void main(String[] args) throws IOException {
	//	System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(x.readLine()); 
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a > 2 * b || b > 2 * a) System.out.println("NO"); // goddamnit 
			else if (a == 0 && b == 0) System.out.println("YES");
			else if (a == 0 || b == 0) System.out.println("NO");
			else if ((a + b) % 3 == 0) System.out.println("YES");
			else System.out.println("NO");
		}
		
		x.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@((((@@@@@@@@@@@@@@@@@@
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#((.   (@@@@@@@@@@@@@@@@@@@
//	@@@@@@@@@@@@@@@@@@@@@@@@(((@((, */(//./@@@@@@@@@@@@@@@@@@@@
//	@@@@@@@@@@@@@@@@@@@@&(* ,(,/(/,..,((.*((@@@@@@@@@@@@@@@@@@@
//	@@@@@@@@@@@@@@@@@%(*./,/,........//,*..*(((&@@@@@@@@@@@@@@@
//	@@@@@@@@@@@@@@@((((/............//*//....../((@@@@@@@@@@@@@
//	@@@@@@@@@@@@@(((/..............*//*/....*,.../((@@@@@@@@@@@
//	@@@@@@@@@@@((/.................//,//./////////./((@@@@@@@@@
//	@@@@@@(@@((/..................***//*//////////////(%@@@@@@@
//	@@@@@(*(((................****.,**//****////##%(///((@@@@@@
//	@@@@/*,#(*.............********(((**/******#  .@@////(@((@@
//	@@@@(,*#(......,......*******#%@@@#(*//****%  .@@@///(((*/@
//	@@@(,.//((((*. ,/....******/#    *@@(**/***%@@@@@@%///(( (@
//	@@@(........../.(,../******#@    @@@@/**/**(@@@@@@@///(/.* 
//	@@//.........../.(.//******%@@@@@@@@@%******&@&&&&&///(.*(*
//	@@(**/((((///.../.(////****%@@@@@@@@@@***////%%%%%%//(/.((,
//	@@@(*//((((/////./*(/////**(@@@@@@@@@@*////////###//((,(/(@
//	@@@@(*//((((//////// ,//////%&&&&&&&&%*///////////((*(///(@
//	@@@@@(**//(/////////////,////%%%%%%%%*////////////(.(//*(@@
//	@@@@@@*/***//////////////,/////#####*/////////*,*.//***(@@@
//	@@@@@@@@/,,***************,,****************/./****,,,/@@@@
//	@@@@@@@@@/,,,,,,************,.*************,.*,,,,,.,*@@@@@
//	@@@@@@@%...*..,,,,,,,,,,,,,,,,,,.,,,,,,,,..,,,.....*@@@@@@@
//	@@@@@...................,,,......................,  @@@@@@@
//	@@@@@@.......       ..............      ...   ....... &@@@@
//	@@@@@@@@@.....                                 ..@@@@@@@@@@
//	@@@@@@@@@@@@@@@@@@@@@.                       .....@@@@@@@@@
}



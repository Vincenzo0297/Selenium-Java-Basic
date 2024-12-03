
public class test3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//While loop

		//1 to 10
		int i=10;

		/* while(i>0) {
			System.out.println(i);
			i--;
		//i=2
			}
		}*/
		
		int j=20;
		do{
			System.out.println(j);
			j++;

		}while(j>30);// 1 loop of execution is guarantee
		
		
		
		
		
		
		// TODO Auto-generated method stub

		// 1 to 10

		/* for(initization;condition;increment)
		{

		}*/
		/* if(5>2)
		{


		System.out.println("success");
		System.out.println("second step");
		}

		else

		System.out.println("fail");*/


		for(int i=0;i<10;i=i+3) {
			if(i==9) {
				System.out.println(" 9 is displayed");
			}else {
				System.out.println("I didnot find");//
			}
			
		}
		
		
		// TODO Auto-generated method stub
		//nested loops works -
		int k=1;
		//(outer for loop) this block will loop for 4 times
		for(int i=0;i<4;i++){
			//System.out.println( "outer loop started");
			for(int j=1;j<=4-i;j++){
				// inner loop
				System.out.print( k);
				System.out.print("\t");
				k++;
			}
		//System.out.println( "");
		}
		
		// TODO Auto-generated method stub
		//int k=1;
		for(int i=1;i<5;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j);
				System.out.print("\t");
				//k++;
			}
			System.out.println("");
		}

	}

	
}

package actions;


import java.util.Scanner; 

public class Stream {
	
	public static Scanner o_scanner = new Scanner(System.in);
	static int modeInt;
	
	public static void modeInput() {
		System.out.println("Willkommen bei Snake! Bitte geben Sie bitte die '1' für den Standardmodus "
				+ "oder die '2' für den freien Modus in der Konsole ein.");
		setModeInt(o_scanner.nextInt());
		
	}

	public static int getModeInt() {
		return modeInt;
	}

	public static void setModeInt(int modeInt) {
		Stream.modeInt = modeInt;
	}
	
}

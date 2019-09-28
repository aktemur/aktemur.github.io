import java.io.*;

public class WriteFile {
	private static int bitChecker(byte byteToCheck, int index) {
		if ((byteToCheck & (1 << index)) != 0) // enter the size of index and bitwise and operation
			return 1;
		else
			return 0;
	}
	public void writeHtml(String htmlName, byte[][] data, char[][] characters)throws IOException {
		String text = "<html> \n<body> \n<link rel=stylesheet href=\"cssFile.css\" type\"text/css\" media= screen>\n";
		text += "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">";
		try {
			write(htmlName + ".html", text);
		} catch (IOException e) {
			System.err.println("IOException" + e.getMessage());
		}
		for (int i = 0; i < data.length; i++) { 
			text = "<tr>\n";
			for (int j = 0; j < data[i].length; j++) { 
				System.out.print(data[i][j]);
				text += "<td class=\"" + characters[i][j] + "_"
						+ bitChecker(data[i][j], 7) + "_"
						+ bitChecker(data[i][j], 5) + "_"
						+ bitChecker(data[i][j], 3) + "_"
						+ bitChecker(data[i][j], 1) + "\"/> ";
			}
			text += "</tr>\n"; //add row
			try {
				write(htmlName + ".html", text);
			} catch (IOException e) {
				System.err.println("IOException" + e.getMessage());
			}
		}
		text = "</table>\n</body>\n</html>\n"; 
		try {
			write(htmlName + ".html", text);
		} catch (IOException e) {
			System.err.println("IOException" + e.getMessage());
		}
	}
	public void WriteIt(String outString, byte[][] data) throws IOException {
		FileWriter output = new FileWriter(outString, true);
		BufferedWriter outBuffer = new BufferedWriter(output);
		outBuffer.write(data.length);
		outBuffer.newLine();
		outBuffer.write(data[0].length);
		outBuffer.newLine();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j]);
				outBuffer.write(data[i][j]);
			}
			outBuffer.newLine();
		}
		outBuffer.close();
	}
	public void write(String outString, String toAppend) throws IOException {
		FileWriter output = new FileWriter(outString);
		BufferedWriter outBuffer = new BufferedWriter(output);
		outBuffer.write(toAppend);
		outBuffer.newLine();
		outBuffer.close();
	}
}

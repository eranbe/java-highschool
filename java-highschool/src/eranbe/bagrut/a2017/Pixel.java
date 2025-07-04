package eranbe.bagrut.a2017;

public class Pixel {
	private int red, green, blue;
	public Pixel() {
		red = 0;
		green = 0;
		blue = 0;
	}
	
	public Pixel(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public void mix(Pixel pxl) {
		this.red = (this.red + pxl.red) / 2;
		this.green = (this.green + pxl.green) / 2;
		this.blue = (this.blue + pxl.blue) / 2;
	}
	
	public static class Pic50 {
		private Pixel[][] pic = new Pixel[50][50];
		
		public void mix(Pic50 otherPic) {
			for (int i = 0; i < pic.length; i++) {
				for (int j = 0; j < pic[i].length; j++) {
					pic[i][j].mix(otherPic.pic[i][j]);
				}
			}
		}
	}
}

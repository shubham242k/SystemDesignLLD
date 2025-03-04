interface Image {
	void display();
}

class RealImage implements Image{
	String fileName;
	RealImage(String fileName) {
		this.fileName = fileName;
		loadImage();
	}

	public void loadImage() {
		System.out.println("Load image: " + fileName);
	}

	public void display() {
		System.out.println("display image: " + fileName);
	}
}

class ImageProxy implements Image {
	String fileName;
	RealImage realImage;
	int userId;

	ImageProxy(String fileName, int userId){
		this.userId = userId;
		if(userId != 1) {
			System.out.println("Access denied to user #" + userId);
		} else {
			this.fileName = fileName;
			this.userId = userId;
		}
	}

	public void display(){
		if(userId != 1) {
			System.out.println("Access denied to user #" + userId);
			return;
		}

		if(realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}
}

public class ProxyPattern {
	public static void main(String[] args) {
		ImageProxy proxy = new ImageProxy("abc.png", 2);
		proxy.display();
		proxy.display();
	}
}
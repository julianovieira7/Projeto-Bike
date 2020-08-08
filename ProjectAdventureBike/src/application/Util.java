package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import org.apache.commons.codec.digest.DigestUtils;

public class Util {
	public static final String PATH_IMAGES = File.separator + "images";

	public static final String PATH_IMAGES_PRODUTO = PATH_IMAGES + File.separator + "produto";
	public static final String PATH_IMAGES_BICICLETA = PATH_IMAGES + File.separator + "bicicleta";
	public static final String PATH_IMAGES_USUARIO = PATH_IMAGES + File.separator + "usuario";
	
	public static String hashSHA256(String valor) {
		return DigestUtils.sha256Hex(valor);
	}

	public static void addMessageInfo(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}

	public static void addMessageWarn(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, null));
	}

	public static void addMessageError(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
	}

	public static boolean saveImageProduto(InputStream inputStream, String imageType, int idProduto) {
		// Exemplo da maquina do janio: /home/janio/images/professor
		String diretorio = System.getProperty("user.home") + PATH_IMAGES_PRODUTO;

		// Criando os diretorios caso nao exista
		File file = new File(diretorio);
		if (!file.exists()) {
			file.mkdirs(); // mkdirs - cria arquivo ou diretorio (caso o diretorio anterior nao exeista ele
							// cria tambem)
		}

		try {
			// criando o espaco de memoria para armazenamento de uma imagem
			// inputStream - eh o fluxo de dados de entrada
			BufferedImage bImage = ImageIO.read(inputStream);

			// estrutura final do arquivo ex: /home/janio/images/professor/01.png
			File arquivoFinal = new File(diretorio + File.separator + idProduto + "." + imageType);
			// salvando a imagem
			// buffer da imagem, png/gif, 01.png
			ImageIO.write(bImage, imageType, arquivoFinal);

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	public static boolean saveImageBicicleta(InputStream inputStream, String imageType, int idBicicleta) {
		// Exemplo da maquina do janio: /home/janio/images/professor
		String diretorio = System.getProperty("user.home") + PATH_IMAGES_BICICLETA;

		// Criando os diretorios caso nao exista
		File file = new File(diretorio);
		if (!file.exists()) {
			file.mkdirs(); // mkdirs - cria arquivo ou diretorio (caso o diretorio anterior nao exeista ele
							// cria tambem)
		}

		try {
			// criando o espaco de memoria para armazenamento de uma imagem
			// inputStream - eh o fluxo de dados de entrada
			BufferedImage bImage = ImageIO.read(inputStream);

			// estrutura final do arquivo ex: /home/janio/images/professor/01.png
			File arquivoFinal = new File(diretorio + File.separator + idBicicleta + "." + imageType);
			// salvando a imagem
			// buffer da imagem, png/gif, 01.png
			ImageIO.write(bImage, imageType, arquivoFinal);

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	public static boolean saveImageUsuario(InputStream inputStream, String imageType, int idUsuario) {
		// Exemplo da maquina do janio: /home/janio/images/professor
		String diretorio = System.getProperty("user.home") + PATH_IMAGES_USUARIO;

		// Criando os diretorios caso nao exista
		File file = new File(diretorio);
		if (!file.exists()) {
			file.mkdirs(); // mkdirs - cria arquivo ou diretorio (caso o diretorio anterior nao exeista ele
							// cria tambem)
		}

		try {
			// criando o espaco de memoria para armazenamento de uma imagem
			// inputStream - eh o fluxo de dados de entrada
			BufferedImage bImage = ImageIO.read(inputStream);

			// estrutura final do arquivo ex: /home/janio/images/professor/01.png
			File arquivoFinal = new File(diretorio + File.separator + idUsuario + "." + imageType);
			// salvando a imagem
			// buffer da imagem, png/gif, 01.png
			ImageIO.write(bImage, imageType, arquivoFinal);

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
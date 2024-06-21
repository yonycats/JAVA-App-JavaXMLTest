package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class T02DOMParsingTest {

	public void parse() throws ParserConfigurationException, SAXException, IOException {

		// XML문서를 생성하기 위한 DocumentBuilder 객체 생성하기
		// DocumentBuilderFactory를 이용해서 DocumentBuilder를 만듬, 그냥 그런 과정이 필요하게 되어있음
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();

		// Document 객체 생성하기
		Document document = db.parse(new File("./src/kr/or/ddit/basic/new_book.xml"));

		// root 엘리먼트 접근하기
		Element root = document.getDocumentElement();

		System.out.println("root 엘리먼트 태그명 : " + root.getTagName());

		// 하위 엘리먼트 접근하기
		// 문서에서 만드는 모든 엘리먼트, 공백, 속성, 등등은 모두 Node 타입이다.
		// 자바에서 만드는 모든 자료형이 Object 타입인 것과 비슷한 느낌
		// 그래서 엘리먼트를 get해서 불러올 때, NodeList으로 받음
		NodeList bookNodeList = root.getElementsByTagName("book");
		Node firstBookNode = bookNodeList.item(0); // bookNodeList의 첫번째 항목(book)을 가져옴
		Element firstBookElement = (Element) firstBookNode; // 첫번째 book을 Element에 넣기

		
		// 속성값 접근해보기
		System.out.println("첫번째 book의 isbn : " + firstBookElement.getAttribute("isbn"));
		System.out.println("첫번째 book의 kind : " + firstBookElement.getAttribute("kind"));

		
		// 텍스트로 되어있는 XML문서를 DOM객체화해서 접근해서 불러온 것
		// XML내부의 정보를 getTextContent로 값 가져오기
		// 전체 책 정보 출력하기
		System.out.println("--------------------------------------------------");
		System.out.printf("%8s %8s %12s %10s %8s\n", "ISBN", "분류", "제목", "저자", "가격");
		System.out.println("--------------------------------------------------");

		for (int i = 0; i < bookNodeList.getLength(); i++) {
			Element book = (Element) bookNodeList.item(i);

			String isbn = book.getAttribute("isbn");
			String kind = book.getAttribute("kind");

			String title = book.getElementsByTagName("title").item(0).getTextContent().trim();
			String author = book.getElementsByTagName("author").item(0).getTextContent().trim();
			String price = book.getElementsByTagName("price").item(0).getTextContent().trim();

			System.out.printf("%8s %8s %12s %10s %8s\n", isbn, kind, title, author, price);
		}
		System.out.println("--------------------------------------------------");
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		new T02DOMParsingTest().parse();
	}

}

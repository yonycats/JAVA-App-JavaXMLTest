package kr.or.ddit.basic;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class T01DOMCreationTest {

/*
 	W3C(World Wide Web Consortium) DOM(Document Object Model) 표준에 대하여
 	
 	 DOM은 문서에 접근하는 표준방법으로서, 이를 이용하면 플랫폼 및 개발언어에 독립적으로 문서의 내용, 
 	 구조 및 스타일 정보를 동적으로 처리(접근, 수정, 삭제 등) 할 수 있다.
 	 
 	 W3C DOM 표준은 다음과 같이 크게 3가지로 나누어 볼 수 있다.
 	 
 	 Core DOM - 모든 문서타입을 위한 핵심 표준 모델 (API)
 	 XML DOM - XML문서를 위한 표준 모델
 	 HTML DOM - HTML문서를 위한 표준 모델
 	 
 	예를 들면, HTML DOM은 HTML 엘리먼트 요소 및 속성 정보를 처리하기 위한 인터페이스를 제공한다.
 */
	
	public void createDoc() throws ParserConfigurationException, TransformerException, FileNotFoundException, IOException {
		
		// XML문서를 생성하기 위한 DocumentBuilder 객체 생성하기
		// DocumentBuilderFactory를 이용해서 DocumentBuilder를 만듬, 그냥 그런 과정이 필요하게 되어있음
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		// 각 booklist에는 4개의 book이 자식으로 들어가있고, 
		// book 안에는 title, author, price가 엘리먼트로 들어가 있다
		
		
		// Document 객체 생성하기
		Document document = db.newDocument();
		
		// root 엘리먼트 생성
		Element root = document.createElement("root");
		
		// booklist 엘리먼트 생성
		Element booklist = document.createElement("booklist");
		
		
		// booklist 1
		// book 엘리먼트 생성 및 속성값 설정하기
		// setAttribute -> 값을 넣는 메서드
		Element book = document.createElement("book");
		book.setAttribute("isbn", "B001");
		book.setAttribute("kind", "JAVA");
		
		// 자식 엘리먼트 생성 및 내용 설정하기
		Element title = document.createElement("title");
		title.setTextContent("JAVA초급");
		
		Element author = document.createElement("author");
		author.setTextContent("이순신");
		
		Element price = document.createElement("price");
		price.setTextContent("25000");
		
		// book 엘리먼트에 자식 엘리먼트 추가하기
		book.appendChild(title);
		book.appendChild(author);
		book.appendChild(price);
		
		// booklist 엘리먼트에 book 엘리먼트를 자식으로 추가하기
		booklist.appendChild(book);
		
		
		//////////////////////////////////////////
		
		// booklist 2
		// 변수 초기화해서 재활용
		// book 엘리먼트 생성 및 속성값 설정하기
		book = document.createElement("book");
		book.setAttribute("isbn", "B002");
		book.setAttribute("kind", "JAVA");
		
		// 자식 엘리먼트 생성 및 내용 설정하기
		title = document.createElement("title");
		title.setTextContent("JAVA고급");
		
		author = document.createElement("author");
		author.setTextContent("홍길동");
		
		price = document.createElement("price");
		price.setTextContent("30000");
		
		// book 엘리먼트에 자식 엘리먼트 추가하기
		book.appendChild(title);
		book.appendChild(author);
		book.appendChild(price);
		
		// booklist 엘리먼트에 book 엘리먼트를 자식으로 추가하기
		booklist.appendChild(book);
		
		
		//////////////////////////////////////////
		
		// booklist 3
		// 변수 초기화해서 재활용
		// book 엘리먼트 생성 및 속성값 설정하기
		book = document.createElement("book");
		book.setAttribute("isbn", "B003");
		book.setAttribute("kind", "DB");
		
		// 자식 엘리먼트 생성 및 내용 설정하기
		title = document.createElement("title");
		title.setTextContent("DB설계");
		
		author = document.createElement("author");
		author.setTextContent("강감찬");
		
		price = document.createElement("price");
		price.setTextContent("35000");
		
		// book 엘리먼트에 자식 엘리먼트 추가하기
		book.appendChild(title);
		book.appendChild(author);
		book.appendChild(price);
		
		// booklist 엘리먼트에 book 엘리먼트를 자식으로 추가하기
		booklist.appendChild(book);
		
		
		//////////////////////////////////////////
		
		// booklist 4
		// 변수 초기화해서 재활용
		// book 엘리먼트 생성 및 속성값 설정하기
		book = document.createElement("book");
		book.setAttribute("isbn", "B004");
		book.setAttribute("kind", "DB");
		
		// 자식 엘리먼트 생성 및 내용 설정하기
		title = document.createElement("title");
		title.setTextContent("DB구현");
		
		author = document.createElement("author");
		author.setTextContent("안중근");
		
		price = document.createElement("price");
		price.setTextContent("45000");
		
		// book 엘리먼트에 자식 엘리먼트 추가하기
		book.appendChild(title);
		book.appendChild(author);
		book.appendChild(price);
		
		// booklist 엘리먼트에 book 엘리먼트를 자식으로 추가하기
		booklist.appendChild(book);
		
		
		
		// root 엘리먼트에 booklist를 자식으로 추가하기
		root.appendChild(booklist);
		
		// 도큐먼트에 root 엘리먼트를 자식으로 추가하기
		document.appendChild(root);
		
		/* 여기까지의 과정이 하나의 XML 문서를 만드는 과정 */
		
		
		
		// XML 문서 변환기 생성하기
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		
		// 출력 인코딩 정보 설정하기 
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		
		// <새로 시작되는 줄의 첫머리>, 즉 태그를 기준으로 줄바꿈하겠다.
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		// 들여쓰기 설정 (공백크기 : 2)
		// {http://xml.apache.org/xslt}indent-amount 속성은 XSLT 스타일시트에서 사용되는 속성
		// 출력 XML 문서의 들여쓰기 양을 지정하는 데 사용된다
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		
		// XML문서 변환 작업하기
		// 변환할 XML 문서를 나타내는 DOMSource 객체를 생성
		// document는 이미 생성된 XML 문서를 나타내는 org.w3c.dom.Document 객체이다.
		DOMSource source = new DOMSource(document);
		
		/* StreamResult 클래스는 JAXP 라이브러리에서 변환된 결과물을 출력하는 용도로 사용되며, 
		 XML뿐만 아니라 다른 형식의 문서 출력에도 사용될 수 있다.
		 StreamResult는 XML뿐만 아니라 다른 형식의 문서 출력에도 사용될 수 있는 범용적인 클래스이며,
		 변환된 결과물을 어떤 형태로든 출력하는 데 사용할 수 있다.
		 예를 들어, HTML, JSON, 텍스트 파일 등 다양한 형식의 문서 출력에 StreamResult를 사용할 수 있다. 
		 출력 대상만 적절히 지정하면 됨. */
		StreamResult result = new StreamResult();
		
		// 1. 바이트 배열에 문서 저장하는 경우
		// 바이트 배열 형태로 변환된 XML 문서를 저장할 ByteArrayOutputStream 객체를 생성
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// baos에 저장함
		// ByteArrayOutputStream 객체를 StreamResult 객체의 출력 대상으로 설정
		// 즉, 변환된 XML 문서가 baos에 저장되도록 함
		result.setOutputStream(baos);
		// source에 지정된 XML 문서를 변환하여 result에 지정된 출력 대상(여기서는 baos)에 저장한다.
		transformer.transform(source, result); // 문서변환 시작
		
		System.out.println(new String(baos.toByteArray(), StandardCharsets.UTF_8));
		
		
		// 2. 파일에 문서를 저장하는 경우
		
		// try-with-resource : try 내부에 선언한 close 해야하는 객체들은 try를 지나 
		// finally에서 자동으로 close된다. 따로 정의하지 않아도 됨
		// 참고 -> https://mangkyu.tistory.com/217
		
		// ./src/kr/or/ddit/basic/new_book.xml에 파일이 저장됨
		try (FileOutputStream fos = new FileOutputStream("./src/kr/or/ddit/basic/new_book.xml")) {
			result.setOutputStream(fos);
			transformer.transform(source, result); // 문서 변환 시작
		}
		
		/*
		 // *** JSON 데이터 생성 (예시)
			JSONObject jsonData = new JSONObject();
			jsonData.put("name", "John Doe");
			jsonData.put("age", 30);
			jsonData.put("email", "john.doe@example.com");
			
			// JSON 데이터를 파일로 출력
			File outputFile = new File("output.json");
			StreamResult result = new StreamResult(outputFile);
			
			// 변환 작업 수행
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(jsonData.toString());
			transformer.transform(source, result);
			
			// StreamResult가 내부적으로 FileOutputStream을 생성하고 관리하기 때문에, 
			// 별도의 FileOutputStream 객체를 생성할 필요가 없다.
		 */
	}
	
	
	public static void main(String[] args) throws ParserConfigurationException, TransformerException, FileNotFoundException, IOException {
		new T01DOMCreationTest().createDoc();
	}
	
}

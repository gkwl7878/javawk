package day0327;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CreateXml {
	
	public List<String> data(){
		List<String> list =new ArrayList<String>();
		list.add("�����Դ³�");
		list.add("ȭ���ϰԸԴ³�");
		list.add("�������̸Դ³�");
		list.add("���� ������ �Դ³�");
		list.add("�ݻ��԰� �� �Դ³�");
		list.add("���ϸ鼭 �Դ³�");
		list.add("������ ã�ƴٴϸ� �Դ³�");
		return list;
	}//data
	
	public String createXml(List<String> weekMsg) {
		StringBuilder xml = new StringBuilder();
		xml.append("<? xml verson='1.0' encording='UTF-8' ?>\n");
		xml.append("<week>\n");
		
		for(int i=0;i<weekMsg.size();i++) {
			xml.append("\t<msg>").append(weekMsg.get(i)).append("</msg>\n");
		}//end for
		
		xml.append("</week>");
		return xml.toString();
	}//createXml
	
	public void createXmlFile(String xml)throws IOException {
		BufferedWriter bw= null;
		
		try {
			bw= new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("C:/dev/workspace/jsp_prj/WebContent/xml0327/msg.xml"),"UTF-8"));
			bw.write(xml);
			bw.flush();
		}finally {
			if(bw!=null) {bw.close();}//end if
		}//end finally
		
	}//createXmlFile
	
	public static void main(String[] args) {
		CreateXml c= new CreateXml();
		try {
			c.createXmlFile(c.createXml(c.data()));
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}
}

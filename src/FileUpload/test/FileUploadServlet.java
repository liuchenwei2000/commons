/**
 * 
 */
package test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * FileUpload�ļ��ϴ�ʾ��
 * <p>
 * ����ɲ���Tomcat����Ϊһ��servlet���в��ԡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-7-7
 */
public class FileUploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7419229593339274585L;

	private static final String TEMP_DIR = "C:/temp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (isMultipart) {
			try {
				// Create a factory for disk-based file items
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// ������ֵ����С������ֵ���ļ�ֱ��д�뵽���̡�
				factory.setSizeThreshold(1024);
				// ������ʱ�ļ��У���С������ֵ���ļ��ᱻ��ʱ�洢����ʱ�ļ���
				factory.setRepository(new File(TEMP_DIR));

				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);
				// ���õ����ϴ��ļ��Ĵ�С���ޣ���λ���ֽ�
				upload.setFileSizeMax(1024 * 1024 * 2);
				// Parse the request
				List<FileItem> fileItems = upload.parseRequest(req);
				// Process the uploaded items
				for (FileItem fileItem : fileItems) {
					// Process a file upload
					if (!fileItem.isFormField()) {
						System.out.println(req.getRemoteAddr() + "�ϴ��ļ�" + fileItem.getName());
						System.out.println(fileItem.getFieldName() + ":" + fileItem.getName());
						System.out.println("���ͣ�" + fileItem.getContentType());
						System.out.println("�ļ���С" + fileItem.getSize());

						File uploadedFile = new File("F:/download" + fileItem.getName());
						fileItem.write(uploadedFile);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

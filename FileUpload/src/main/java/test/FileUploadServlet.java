/**
 * 
 */
package test;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * FileUpload文件上传示例
 * <p>
 * 本类可部署到Tomcat中作为一个servlet进行测试。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-7-7
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

				// 设置阈值，大小超过该值的文件直接写入到磁盘。
				factory.setSizeThreshold(1024);
				// 设置临时文件夹，大小超过阈值的文件会被临时存储到临时文件夹
				factory.setRepository(new File(TEMP_DIR));

				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);
				// 设置单个上传文件的大小上限，单位是字节
				upload.setFileSizeMax(1024 * 1024 * 2);
				// Parse the request
				List<FileItem> fileItems = upload.parseRequest(req);
				// Process the uploaded items
				for (FileItem fileItem : fileItems) {
					// Process a file upload
					if (!fileItem.isFormField()) {
						System.out.println(req.getRemoteAddr() + "上传文件" + fileItem.getName());
						System.out.println(fileItem.getFieldName() + ":" + fileItem.getName());
						System.out.println("类型：" + fileItem.getContentType());
						System.out.println("文件大小" + fileItem.getSize());

						File uploadedFile = new File("D:/download" + fileItem.getName());
						fileItem.write(uploadedFile);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

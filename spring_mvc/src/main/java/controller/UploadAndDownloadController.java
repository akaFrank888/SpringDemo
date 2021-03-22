package controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author yxl15
 * @date 2021/3/19 14:41
 * @description
 *
 *      文件的上传和下载
 *
 */
@Controller
@RequestMapping("/uploadAndDownload")
public class UploadAndDownloadController {

    /**
     * 获得请求参数————单文件与多文件上传
     */
    @RequestMapping("/upload")
    @ResponseBody
    public void upload(@RequestParam("name") String name, @RequestParam("uploadFileName") List<MultipartFile> uploadFile, HttpServletRequest request) {

        System.out.println("上传人姓名是：" + name);

        // 判断上传的文件是否存在
        if (!uploadFile.isEmpty()) {
            // 建立循环，遍历上传文件
            for (MultipartFile file : uploadFile) {
                // 获取上传文件的原始名称
                String originalFilename = file.getOriginalFilename();
                // 设置上传文件的保存地址目录
                String dirPath = request.getServletContext().getRealPath("/upload/");

                File filePath = new File(dirPath);
                // 如果保存文件的地址不存在,就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                // 使用UUID重新命名上传的文件名称(格式为:   上传人_uuid_原始文件名称)
                String newFileName = name + "_" + UUID.randomUUID() + "_" + originalFilename;
                try {
                    // 将上传的文件移动到目标路径(在target//spring_mvc//upload下)
                    file.transferTo(new File(dirPath + newFileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("文件上传成功");

    }

    /**
     * @param request,filename
     * @return responseEntity
     * @description 文件的下载
     * @date 2021/3/20 16:58
     */
    @RequestMapping("/download")
    @ResponseBody
    public ResponseEntity<byte[]> fileDownLoad(HttpServletRequest request, String filename) throws IOException {
        // 要下载的文件所在路径
        String path = request.getServletContext().getRealPath("/upload");
        // 创建文件对象(File.separator是分隔符,用于跨平台)
        File file = new File(path + File.separator + filename);
        // 设置响应头,通知浏览器以下载的方式打开文件
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", filename);
        // 定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 使用StringMVC框架的ResponseEntity对象封装返回下载数据
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }

}

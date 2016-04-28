package com.sermo.springmvc4.web;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public @ResponseBody String upload(MultipartFile file){ //使用 MultipartFile file 接受上传的文件
		try {
			// 使用 FileUtils.writeByteArrayToFile 快速写入文件到磁盘
			FileUtils.writeByteArrayToFile(
					new File("e:/upload/"+file.getOriginalFilename()), 
					file.getBytes());
			return "ok";
		} catch (IOException e) {
			e.printStackTrace();
			return "wrong";
		}
		
	}
}

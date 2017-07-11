package com.dgit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.domain.SimProject;
import com.dgit.service.SimProjectService;

@Controller
@RequestMapping("/")
public class SimProjectController {
	//private static final Logger logger = LoggerFactory.getLogger(SimProjectController.class);
	
	@Autowired
	SimProjectService service;
	
	@RequestMapping(value="newProject", method=RequestMethod.GET)
	public String newProjectGET() throws Exception{
		return "newProjectForm";
	}
	
	@RequestMapping(value="newProject", method=RequestMethod.POST)
	public String newProjectPOST(Model model, SimProject sim, String startDate, String endDate) throws Exception{
		SimpleDateFormat d_format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date resultStartDate = d_format.parse(startDate);
		Date resultendDate = d_format.parse(endDate);
		
		sim.setStart_date(resultStartDate);
		sim.setEnd_date(resultendDate);
		
		service.insert(sim);
		
		return listAllGET(model);
	}
	
	@RequestMapping(value="listAll", method=RequestMethod.GET)
	public String listAllGET(Model model) throws Exception{
		String resultStartDate = null;
		String resultEndDate = null;
		
		List<SimProject> list = service.selectList();
		
		SimpleDateFormat d_format = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<SimProject> viewSimProjectList = new ArrayList<SimProject>();
		
		for(SimProject s : list){
			resultStartDate = d_format.format(s.getStart_date());
			resultEndDate = d_format.format(s.getEnd_date());
			SimProject getData = new SimProject(s.getNumber(), s.getName(), 
					s.getContent(), resultStartDate, resultEndDate, s.getState());
			viewSimProjectList.add(getData);
		}
		
		model.addAttribute("viewSimProjectList", viewSimProjectList);
		return "simProjectList";
	}
	
	/*@RequestMapping(value="listPage", method=RequestMethod.GET)
	public String listPage(Model model, @ModelAttribute("cri") SearchCriteria cri) throws Exception{
		logger.info("----------list----------GET");
		
		model.addAttribute("list",service.listSearch(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		
		return "sboard/listPage";
	}
	
	@RequestMapping(value="listAll", method=RequestMethod.POST)
	public String listAllPOST(Model model, BoardVO vo, List<MultipartFile> imgFiles) throws Exception{
		logger.info(vo.toString());
		ArrayList<String> listFile = new ArrayList<>();
		
		List<BoardVO> list = service.listAll();
		model.addAttribute("list", list);
		
		for(MultipartFile file : imgFiles){
			logger.info("filename : " + file.getOriginalFilename());
			
			String thumb = UploadFileUtils.uploadFile(uploadPath, 
					file.getOriginalFilename(), 
					file.getBytes());
			listFile.add(thumb);
		}
		vo.setFiles(listFile.toArray(new String[imgFiles.size()]));
		for(String e : vo.getFiles()){
			System.out.println(e);
		}
		service.regist(vo);
		return "sboard/listPage";
	}*/
	
	@RequestMapping(value="content", method=RequestMethod.GET)
	public String content(Model model, int number) throws Exception{
		String resultStartDate = null;
		String resultEndDate = null;
		
		SimProject getNoData = service.selectByNo(number);
		
		SimpleDateFormat d_format = new SimpleDateFormat("yyyy-MM-dd");
		
		resultStartDate = d_format.format(getNoData.getStart_date());
		resultEndDate = d_format.format(getNoData.getEnd_date());
		
		SimProject byNo = new SimProject(getNoData.getNumber(), getNoData.getName(), 
				getNoData.getContent(), resultStartDate, resultEndDate, getNoData.getState());
		
		model.addAttribute("byNo", byNo);
		
		return "simProjectContent";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(Model model, int number) throws Exception{
		service.delete(number);
		return listAllGET(model);
	}
	
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public String modifyGET(Model model, SimProject sim, String startDate, String endDate) throws Exception{
		model.addAttribute("sim", sim);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		return "modifyProjectForm";
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modifyPOST(Model model, SimProject sim, String startDate, String endDate) throws Exception{
		SimpleDateFormat d_format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date resultStartDate = d_format.parse(startDate);
		Date resultendDate = d_format.parse(endDate);
		
		sim.setStart_date(resultStartDate);
		sim.setEnd_date(resultendDate);
		
		service.update(sim);
		return content(model, sim.getNumber());
	}
	
	/*@ResponseBody
	@RequestMapping(value="displayFile") //  /filename
	public ResponseEntity<byte[]> displayFile(String filename) throws IOException{
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		
		logger.info("----- displayFile : " + filename);
		
		try{
			String formatName = filename.substring(filename.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(mType);
			
			in = new FileInputStream(uploadPath + "/" + filename);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), header, HttpStatus.CREATED); //in에 있는 바이트 배열을 꺼내줌
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(Model model, int bno, @ModelAttribute("cri") SearchCriteria cri) throws Exception{
		service.remove(bno);
		return listPage(model, cri);
	}
	
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public String modifyGET(Model model, int bno, @ModelAttribute("cri") SearchCriteria cri, String[] imgList) throws Exception{
		BoardVO vo = service.read(bno);
		
		if(imgList != null){
			for(int i=0 ; i<imgList.length ; i++){
				if(i==0){
					imgList[i] = imgList[i].substring(imgList[i].indexOf("[")+1);
				}else if(i==imgList.length-1){
					imgList[i] = imgList[i].substring(0, imgList[i].lastIndexOf("]"));
				}
			}
			
			model.addAttribute("imgList", imgList);
			model.addAttribute("nullCheck", false);
		}else if(imgList == null){
			model.addAttribute("nullCheck", true);
		}
		
		model.addAttribute("modify", true);
		model.addAttribute("board", vo);
		
		return "sboard/register";
	}
	
	@RequestMapping(value="modify2", method=RequestMethod.GET)
	public String modifyPOST(Model model, BoardVO vo, @ModelAttribute("cri") SearchCriteria cri, String[] delImgList) throws Exception{
		service.modify(vo);
		
		for(String img : delImgList){
			File file = new File(uploadPath + img);
			file.delete();
			
			String front = img.substring(0, 12);
			String end = img.substring(14);
			String originalName = front + end;
			File file2 = new File(uploadPath + originalName);
			file2.delete();
			System.out.println(vo.getBno());
			service.delAttach(img, vo.getBno());
		}
		
		model.addAttribute("board", vo);
		//rttb.addArrtibute("aaa", aaa);
		//return "redirect:read";
		return "sboard/read";
	}*/
}

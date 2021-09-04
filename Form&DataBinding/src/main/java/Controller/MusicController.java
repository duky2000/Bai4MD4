package Controller;

import Model.Music;
import Service.MailboxService;
import Service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class MusicController {
    MusicService musicService = new MusicService();

    @RequestMapping("homemusic")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("homeMusic");
        modelAndView.addObject("list",musicService.list);
        return modelAndView;
    }



    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("list", new Music());
        return modelAndView;
    }
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam int index){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("music",musicService.list.get(index));
        modelAndView.addObject("index",index);
        return modelAndView;
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int index) {
        musicService.delete(index);
        return "redirect:/homemusic";
    }
    @PostMapping("create")
    public String create(@RequestParam MultipartFile upMusic,@ModelAttribute Music music){
        String nameMusic = upMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(upMusic.getBytes(), new File("C:\\Users\\DELL\\IdeaProjects\\untitledv\\src\\main\\webapp\\file\\" + nameMusic));
            String urlImg = "/upload/file/" + nameMusic;
            music.setFile(urlImg);
        } catch (Exception e) {
            System.err.println("err upload file");
        }
        musicService.add(music);
        return "redirect:/homemusic";
    }
    @PostMapping("/edit")
    public String edit(@RequestParam MultipartFile upFile,@ModelAttribute Music music, @RequestParam int index) {
        String nameImg = upFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(upFile.getBytes(), new File("C:\\Users\\DELL\\IdeaProjects\\untitledv\\src\\main\\webapp\\file\\" + nameImg));
            String urlImg = "/upload/file/" + nameImg;
            music.setFile(urlImg);
        } catch (IOException e) {
            System.err.println("error upload file");
            e.printStackTrace();
        }
        musicService.edit( music,index);
        return "redirect:/homemusic";
    }
}

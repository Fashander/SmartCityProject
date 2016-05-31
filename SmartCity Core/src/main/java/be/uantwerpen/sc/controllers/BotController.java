package be.uantwerpen.sc.controllers;

import be.uantwerpen.sc.models.Bot;
import be.uantwerpen.sc.services.BotControlService;
import be.uantwerpen.sc.services.LinkControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Thomas on 25/02/2016.
 */
@RestController
@RequestMapping("/bot/")
public class BotController
{
    @Autowired
    private BotControlService botControlService;
    @Autowired
    private LinkControlService linkControlService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Bot> allBots(){
        List<Bot> robotEntityList = botControlService.getAllBots();
        return robotEntityList;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Bot getBot(@PathVariable("id") Long id){return  botControlService.getBot(id);}

    @RequestMapping(value = "{id}",method = RequestMethod.POST)
    public void saveBot(@PathVariable("id") Long id,@RequestBody Bot bot){
        botControlService.saveBot(bot);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public void updateBot(@PathVariable("id") Long id,@RequestBody Bot bot){
        botControlService.updateBot(bot);
    }

    @RequestMapping(value = "updateBotTest/{id}",method = RequestMethod.GET)
    public void updateBotTest(@PathVariable("id") Long id){
        Bot botEntity = new Bot();
        botEntity.setRid(id);
        botEntity.setState("Updated");
        botControlService.updateBot(botEntity);
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public Bot testRestBot(){
        return new Bot();
    }

    @RequestMapping(value = "savetest",method = RequestMethod.GET)
    public void saveBotTest(){
        Bot bot = new Bot();
        bot.setState("test");
        botControlService.saveBot(bot);
    }

    @RequestMapping(value = "goto/{id}/{rid}",method = RequestMethod.GET)
    public String goTo(@PathVariable("id") Long id, @PathVariable("rid") Long rid){

        Bot botEntity = botControlService.getBot(rid);
        /*if (!pointEntities.contains(botEntity.getLinkId().getStopId())){
            pointEntities.add(botEntity.getLinkId().getStopId());
        }*/
        if (botEntity != null) {
            if (botEntity.getPercentageCompleted() >= 50) {
               // stack.push(botEntity.getLinkId().getStopId());
            }
        }
        else{System.out.println("Robot doesnt exist");}

        return "Something";
    }

    @RequestMapping(value = "newRobot",method = RequestMethod.GET)
    public Long newRobot(){
        Long newID;
        if(botControlService.getAllBots() != null &&!botControlService.getAllBots().isEmpty()) {
            //Get new ID
            List<Bot> botEntities = botControlService.getAllBots();
            Long lastID = botEntities.get(botEntities.size()-1).getRid();
            newID = ++lastID;
        }else{
            newID = (long)0;
        }

        //Save Robot
        Bot bot = new Bot();
        bot.setRid(newID);
        botControlService.saveBot(bot);
        Date date = new Date();
        System.out.println("New robot created!!" + date.toString());

        return newID;
    }

    @RequestMapping(value = "{id}/lid/{lid}",method = RequestMethod.GET)
    public void locationLink(@PathVariable("id") Long id,@PathVariable("lid") int lid){
        Bot botEntity = this.getBot(id);
        botEntity.setLinkId(linkControlService.getLink(lid));
        botControlService.updateBot(botEntity);
    }

    public void updateLocation(Long id, int mm){
        Bot botEntity = this.getBot(id);
        botEntity.setPercentageCompleted(mm);
        botEntity.setState("Updated");
        botControlService.updateBot(botEntity);
    }

    @RequestMapping(value = "/delete/{rid}",method = RequestMethod.GET)
    public void deleteBot(@PathVariable("rid") Long rid){
        botControlService.deleteBot(rid);
        System.out.println("Robot with id: " + rid + " deleted from DB");
    }

    @RequestMapping(value = "/resetbots}",method = RequestMethod.GET)
    public void resetBots()
    {
        botControlService.resetBots();
    }
}

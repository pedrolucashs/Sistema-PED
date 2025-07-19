package view;
import controller.EmentaController;
import model.Model;
public class EmentaView {
  private Model model;
  private EmentaController controller;

  public void init(Model model){
    this.model = model;
    this.controller = new EmentaController;
    
  }
    
}

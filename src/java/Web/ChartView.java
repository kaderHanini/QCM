package Web;


import DAO.QuestionFacadeLocal;
import Entities.Question;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
 
@ManagedBean
public class ChartView implements Serializable {
    @EJB
    private QuestionFacadeLocal DAOQuestion;
    private List<Question> listeQuestion;
    
    private PieChartModel pieModel;
    
    

    public PieChartModel getPieModel() {
        listeQuestion = DAOQuestion.findAll();
        int NbInfo=0;
        int NbScience=0;
        int NbMerise=0;
        int NbBdd=0;
        int NbInternet=0;
        
                for(int i=0;i<listeQuestion.size();i++){
                    if(listeQuestion.get(i).getTheme().equals("Informatique"))NbInfo++;
                    else 
                        if(listeQuestion.get(i).getTheme().equals("Science"))NbScience++;
                    else
                            if (listeQuestion.get(i).getTheme().equals("Merise"))NbMerise++;
                            else 
                                if (listeQuestion.get(i).getTheme().equals("internet"))NbInternet++;
                            else 
                                    if(listeQuestion.get(i).getTheme().equals("Base de donnée"))NbBdd++;
                }
            pieModel = new PieChartModel();
            
            pieModel.set("Informatique", NbInfo);
            pieModel.set("Science", NbScience);
            pieModel.set("Merise", NbMerise);
            pieModel.set("internet", NbInternet);
            pieModel.set("Base de donnée", NbBdd);
            
            
            pieModel.setTitle("Type de question");
            pieModel.setLegendPosition("e");
            pieModel.setFill(true);
            pieModel.setShowDataLabels(true);
            pieModel.setDiameter(300);


            return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
    
    
    
    
    
    public QuestionFacadeLocal getDAOQuestion() {
        return DAOQuestion;
    }

    public void setDAOQuestion(QuestionFacadeLocal DAOQuestion) {
        this.DAOQuestion = DAOQuestion;
    }

    
    
    public List<Question> getListeQuestion() {
        return listeQuestion;
    }

    public void setListeQuestion(List<Question> listeQuestion) {
        this.listeQuestion = listeQuestion;
    }
    
    
    
    
    
    private BarChartModel barModel;
 
    
    
    
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
   
 
    private BarChartModel initBarModel() {
        
        listeQuestion = DAOQuestion.findAll();
        int NbInfo=0;
        int NbScience=0;
        int NbMerise=0;
        int NbBdd=0;
        int NbInternet=0;
        
                for(int i=0;i<listeQuestion.size();i++){
                    if(listeQuestion.get(i).getTheme().equals("Informatique"))NbInfo++;
                    else 
                        if(listeQuestion.get(i).getTheme().equals("Science"))NbScience++;
                    else
                            if (listeQuestion.get(i).getTheme().equals("Merise"))NbMerise++;
                            else 
                                if (listeQuestion.get(i).getTheme().equals("internet"))NbInternet++;
                            else 
                                    if(listeQuestion.get(i).getTheme().equals("Base de donnée"))NbBdd++;
                }
        
        BarChartModel model = new BarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Matiere");
        boys.set("Informatique", NbInfo);
        boys.set("Science", NbScience);
        boys.set("Merise", NbMerise);
        boys.set("internet", NbInternet);
        boys.set("Base de donnée", NbBdd);
 
 
        model.addSeries(boys);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Matiere");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Effectifs");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
     
}
    
    
    
    
    

   

   

   
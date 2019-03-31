package pl.bykowski.springbootdata;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.soap.Text;
import java.time.LocalDate;

@Route("corpse")
public class CorpseGui extends VerticalLayout {

    @Autowired
    private CorpseRepo corpseRepo;

    private TextField textFieldName = new TextField("Name");
    private ComboBox<CorpseSize> comboBox = new ComboBox<>("Body size");
    private DatePicker datePicker = new DatePicker("Date of death");
    private Button button = new Button("co łaska, ale nie mniej niż 150zł");
    private Image image = new Image();

    public CorpseGui() {
        comboBox.setItems(CorpseSize.values());
        image.setSrc("http://www.gify.net/data/media/631/skarbonka-ruchomy-obrazek-0019.gif");

        button.addClickListener(clickEvent -> addCorpse());
        add(textFieldName);
        add(comboBox);
        add(datePicker);
        add(button);
        add(image);
        image.setVisible(false);
    }

    public void addCorpse() {
        Corpse corpse = new Corpse();
        corpse.setName(textFieldName.getValue());
        corpse.setCorpseSize(comboBox.getValue());
        corpse.setDateOfDeath(datePicker.getValue());
        corpseRepo.save(corpse);
        image.setVisible(true);
    }

}

package billennium.tests.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value // TODO UWAGA do wszystkich klas w pakiecie model  doczytaj co robi adnotacja Value, dzieki niej nie jest
// potrzebny kwalifikator dostepu dla pol w klasie
// TODO kolejna uwaga do wszystkiego w tym pakiecie: Czy nazwanie tego Model jest odpowiednie ? Dlaczego te klasy sa
//  tak nazwane. Mi to bardziej wyglada na jakieś projekcje a nie Model. Tutaj wazne jest nazewnictwo w projekcie. Ja
//  zawsze spotyjalem sie na backendzie ze Model == Entity. Moze to jest jakis DTO ? Proszę o wytlumaczenie dlaczego tak
public class QuestionModel {

    private Long id;
    private String text;
    private List<String> possibleAnswers;
    private String correctAnswers;
    private boolean isCorrect;
}

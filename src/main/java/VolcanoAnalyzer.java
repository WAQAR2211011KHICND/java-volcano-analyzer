import java.io.Console;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.GroupLayout.Group;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class VolcanoAnalyzer {
    private List<Volcano> volcanos;

    public void loadVolcanoes(Optional<String> pathOpt) throws IOException, URISyntaxException {
        try{
            String path = pathOpt.orElse("volcano.json");
            URL url = this.getClass().getClassLoader().getResource(path);
            String jsonString = new String(Files.readAllBytes(Paths.get(url.toURI())));
            ObjectMapper objectMapper = new ObjectMapper();
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            volcanos = objectMapper.readValue(jsonString, typeFactory.constructCollectionType(List.class, Volcano.class));
        } catch(Exception e){
            throw(e);
        }
    }

    public Integer numbVolcanoes(){
        return volcanos.size();
    }

    public List<Volcano> getVolcano(){
        return this.volcanos;
    }

    public List<Volcano> eruptedInEighties(){
            
        List<Volcano> volcanList = new ArrayList<Volcano>(this.volcanos.stream().filter(volcan -> (volcan.getYear() >= 1980 && volcan.getYear() <= 1989)  ).toList());
        return  volcanList;
    }

    public String[] highVEI(){
        
        return this.volcanos.stream()
                            .filter( volcan -> volcan.getVEI() >= 6)
                            .map(volcan -> volcan.getName()).toList().toArray(String[]::new);
    }

    
    public Volcano mostDeadly() {

        
        return this.volcanos.stream().max((Volcano valcan1, Volcano valcan2) -> {
                Integer valcan1Int = Integer.parseInt(valcan1.getDEATHS());
                Integer valcan2Int = Integer.parseInt(valcan2.getDEATHS());
                if ( valcan1Int == valcan2Int ) {
                    return 0;
                } else if (valcan1Int < valcan2Int) {
                    return -1;
                } else {
                    return 1;
                }
                }).orElse(null) ;
        
    }

    public double causedTsunami(){
        double totalErp = this.volcanos.size();
        double totalTsu = this.volcanos.stream()
                    .filter(v-> new String(v.getTsu()).equals("tsu") )
                    .toList().size();

        return (totalTsu/totalErp)*100;
    }

    public String mostCommonType(){
        Map<String, Long > groupCommon = this.volcanos.stream()
        .collect(Collectors.groupingBy( Volcano::getType , Collectors.counting() ));
        return groupCommon.entrySet().stream().max((m1, m2)-> m1.getValue().compareTo(m2.getValue())).get().getKey();
    }

    public int eruptionsByCountry(String country){
        return this.volcanos.stream().filter(v->v.getCountry().equals(country)).toList().size();
    }

    public double averageElevation(){
        return this.volcanos.stream().collect(Collectors.averagingDouble(v->v.getElevation()));
    }

    public String[] volcanoTypes(){
        return this.volcanos.stream()
            .map(v->v.getType()).distinct().toList().toArray(new String[0]);
    }

    public double percentNorth(){
        return (double)this.volcanos.stream()
            .filter(v->v.getLatitude()>0).count()*100/this.volcanos.size();
    }

    
    public String[] manyFilters(){

        return this.volcanos.stream()
            .filter(v-> v.getYear()>1800 && v.getTsu().equals("")
                        && v.getLatitude() < 0 && v.getVEI()==5 )
            .map(v->v.getName())
            .toList()
            .toArray(new String[0]);

    }

    public String[] elevatedVolcanoes(int elevation){
        return this.volcanos.stream()
            .filter(v->v.getElevation()>=elevation)
            .map(v->v.getName())
            .toList().toArray(new String[0]);
    }

    public String[] topAgentsOfDeath(){
    return this.volcanos.stream().sorted((va1,va2)->{
            
           Integer v1 = Integer.parseInt(va1.getDEATHS());
           Integer v2 = Integer.parseInt(va2.getDEATHS());
           return v2-v1;
               }).limit(10)
           .map(v-> Arrays.asList(v.getAgent().split(",")))
           .flatMap(List::stream).distinct()
           .filter(vString->vString.length()>0)
           .toList().toArray(new String[0]);
    }
    //add methods here to meet the requirements in README.md

}

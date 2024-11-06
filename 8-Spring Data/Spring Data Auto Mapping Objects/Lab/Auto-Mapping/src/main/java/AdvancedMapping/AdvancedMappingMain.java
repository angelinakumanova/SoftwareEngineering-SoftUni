package AdvancedMapping;

import AdvancedMapping.entities.Employee;
import AdvancedMapping.entities.dtos.ManagerDTO;
import org.modelmapper.ModelMapper;

import java.util.List;

public class AdvancedMappingMain {
    public static void main(String[] args) {
        Employee first = new Employee("First", "Last", 1200);
        Employee second = new Employee("Second", "Last", 2200);
        Employee third = new Employee("Third", "Last", 3200);
        Employee fourth = new Employee("Fourth", "Last", 4200);

        Employee managerOne = new Employee("Manager", "One", 5200, List.of(first, second, third));
        Employee managerTwo = new Employee("Manager", "Two", 6200, List.of(fourth));

        ModelMapper mapper = new ModelMapper();

        ManagerDTO managerOneDTO = mapper.map(managerOne, ManagerDTO.class);
        System.out.println(managerOneDTO);
    }
}

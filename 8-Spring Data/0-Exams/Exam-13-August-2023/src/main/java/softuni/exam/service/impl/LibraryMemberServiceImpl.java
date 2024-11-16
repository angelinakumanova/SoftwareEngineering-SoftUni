package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.LibraryMemberImportDto;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {
    private final static String LIBRARY_MEMBER_PATH = "src/main/resources/files/json/library-members.json";

    private final LibraryMemberRepository libraryMemberRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, ModelMapper modelMapper, @Qualifier("gson") Gson gson, ValidationUtil validationUtil) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return Files.readString(Path.of(LIBRARY_MEMBER_PATH));
    }

    @Override
    public String importLibraryMembers() throws IOException {
        LibraryMemberImportDto[] libraryMembers = gson.fromJson(readLibraryMembersFileContent(),
                LibraryMemberImportDto[].class);

        StringBuilder sb = new StringBuilder();

        Arrays.stream(libraryMembers)
                .filter(lb -> isValidLibraryMember(lb, sb))
                .map(lb -> modelMapper.map(lb, LibraryMember.class))
                .forEach(lb -> saveLibraryMember(lb, sb));

        libraryMemberRepository.flush();

        return sb.toString();
    }

    @Override
    public Optional<LibraryMember> findById(Long id) {
        return libraryMemberRepository.findById(id);
    }

    private void saveLibraryMember(LibraryMember lb, StringBuilder sb) {
        String formattedLB = String.format("Successfully imported library member %s - %s",
                lb.getFirstName(), lb.getLastName());
        sb.append(formattedLB).append(System.lineSeparator());
        libraryMemberRepository.save(lb);
    }

    private boolean isValidLibraryMember(LibraryMemberImportDto lb, StringBuilder sb) {
        if (!validationUtil.isValid(lb) ||
           libraryMemberRepository.findByPhoneNumber(lb.getPhoneNumber()).isPresent()) {
            sb.append("Invalid library member").append(System.lineSeparator());
            return false;
        }

        return true;
    }
}

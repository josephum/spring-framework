package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @InjectMocks
    ProjectServiceImpl projectService;


    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;



    @Test
    void getByProjectCode_test() {

        // Given (the mocks)
        Project project = new Project();
        ProjectDTO projectDTO = new ProjectDTO();

        when(projectRepository.findByProjectCode(anyString())).thenReturn(project);
        when(projectMapper.convertToDto(project)).thenReturn(projectDTO);

        // Real call to the method
        // When
        ProjectDTO projectDTO1 = projectService.getByProjectCode(anyString());

        // Then
        verify(projectRepository).findByProjectCode(anyString());
        verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(projectDTO1);
    }

    @Test
    void getByProjectCode_exception_test() {

        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project Not Found"));

        Throwable throwable =  assertThrows(RuntimeException.class,()->projectService.getByProjectCode(""));

        verify(projectRepository).findByProjectCode(anyString());
        assertEquals("Project Not Found",throwable.getMessage());
    }

    @Test
    void save_test() {

        // Given (the mocks)
        ProjectDTO projectDTO = new ProjectDTO();
        Project project = new Project();

        when(projectMapper.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

        // When
        projectService.save(projectDTO);

        // Then
        verify(projectRepository).save(project);
        verify(projectMapper).convertToEntity(any(ProjectDTO.class));
    }

}
package com.adryan.sistemaodontologico.config;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.adryan.sistemaodontologico.entity.Consulta;
import com.adryan.sistemaodontologico.entity.Dentista;
import com.adryan.sistemaodontologico.entity.Paciente;
import com.adryan.sistemaodontologico.entity.Procedimento;
import com.adryan.sistemaodontologico.repository.ConsultaRepository;
import com.adryan.sistemaodontologico.repository.DentistaRepository;
import com.adryan.sistemaodontologico.repository.PacienteRepository;
import com.adryan.sistemaodontologico.repository.ProcedimentoRepository;

@Configuration
public class CargaInicial implements CommandLineRunner {

    // Injetando os repositories para salvar no banco
    private final PacienteRepository pacienteRepo;
    private final DentistaRepository dentistaRepo;
    private final ProcedimentoRepository procedimentoRepo;
    private final ConsultaRepository consultaRepo;

    public CargaInicial(PacienteRepository pacienteRepo, DentistaRepository dentistaRepo, 
                        ProcedimentoRepository procedimentoRepo, ConsultaRepository consultaRepo) {
        this.pacienteRepo = pacienteRepo;
        this.dentistaRepo = dentistaRepo;
        this.procedimentoRepo = procedimentoRepo;
        this.consultaRepo = consultaRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        
        // Só roda se não tiver nenhum dentista cadastrado
        if (dentistaRepo.count() == 0) {
            
            // 1. Criando a Dentista (Elisa)
            Dentista elisa = new Dentista();
            elisa.setNome("Dra. Elisa");
            elisa.setEmail("elisa@odonto.com");
            elisa.setSenha("123456");
            elisa.setCro("RJ-59828");
            elisa.setTelefone("22 99999-8888");
            dentistaRepo.save(elisa);

            // 2. Criando um Paciente Teste
            Paciente p1 = new Paciente();
            p1.setNome("Adryan Lima");
            p1.setEmail("adryan@email.com");
            p1.setCpf("123.456.789-00");
            p1.setTelefone("21 98888-7777");
// Substituímos o setAnamnese pelos campos novos:
            p1.setAlergias("Nenhuma");
            p1.setQueixaPrincipal("Paciente relata histórico de bruxismo.");
            pacienteRepo.save(p1);

// 3. Criando Procedimentos Padrão
            Procedimento proc1 = new Procedimento();
            proc1.setNome("Limpeza Completa");
            proc1.setDescricao("Profilaxia e remoção de tártaro");
// Transformamos o Double em BigDecimal:
            proc1.setValorBase(new BigDecimal("150.00"));
            procedimentoRepo.save(proc1);

            Procedimento proc2 = new Procedimento();
            proc2.setNome("Restauração Resina");
            proc2.setDescricao("Restauração simples (1 face)");
            proc2.setValorBase(new BigDecimal("200.00"));
            procedimentoRepo.save(proc2);

            Procedimento proc3 = new Procedimento();
            proc3.setNome("Clareamento");
            proc3.setDescricao("Clareamento caseiro com moldeiras");
            proc3.setValorBase(new BigDecimal("600.00")); // Chutei o valor da linha 73!
            procedimentoRepo.save(proc3);

            procedimentoRepo.saveAll(Arrays.asList(proc1, proc2, proc3));
            
            // 4. Agendando uma Consulta para testar
            Consulta c1 = new Consulta();
            c1.setDentista(elisa);
            c1.setPaciente(p1);
            c1.setDataHora(LocalDateTime.now().plusDays(1).withHour(14).withMinute(0)); // Amanhã às 14h
            c1.setStatus("AGENDADA");
            c1.setObservacao("Avaliação inicial e limpeza");
            consultaRepo.save(c1);

            System.out.println("--------------------------------------------");
            System.out.println("CARGA INICIAL REALIZADA COM SUCESSO! 🚀");
            System.out.println("Dra. Elisa e Paciente Adryan cadastrados.");
            System.out.println("--------------------------------------------");
        }
    }
}
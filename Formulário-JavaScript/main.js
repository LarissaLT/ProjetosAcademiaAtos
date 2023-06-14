
// Ex: 1

function criarLogin() {
    
    let nome = document.getElementById('nome').value.replace(/\s/g,'').toLowerCase();
    let sobrenome = document.getElementById('sobrenome').value.replace(/\s/g,'').toLowerCase();
    document.getElementById('login').value = nome + '.' + sobrenome;
  }


  //Ex:2

  function limpaFormulario() {
    document.getElementById('endereco').value=("");
    document.getElementById('bairro').value=("");
    document.getElementById('cidade').value=("");
    document.getElementById('estado').value=("");
}

    function atualizaFormulario(conteudo) {
    if (!("erro" in conteudo)) {

        let erro = document.getElementById('cep-erro');
        erro.classList.add('d-none');

        document.getElementById('endereco').value=(conteudo.logradouro);
        document.getElementById('bairro').value=(conteudo.bairro);
        document.getElementById('cidade').value=(conteudo.localidade);
        document.getElementById('estado').value=(conteudo.uf);
    } 
    else {
        limpaFormulario();
        let erro = document.getElementById('cep-erro');
        erro.classList.remove('d-none');
    }
}

  function validarCep(valor) {

    let cep = valor.replace(/\D/g, '');

    if (cep != "") {

        let validacep = /^[0-9]{8}$/;

        if(validacep.test(cep)) {

            document.getElementById('endereco').value="...";
            document.getElementById('bairro').value="...";
            document.getElementById('cidade').value="...";
            document.getElementById('estado').value="...";

            let script = document.createElement('script');

            script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=atualizaFormulario';

            document.body.appendChild(script);

        } 
        else {
            limpaFormulario();
            let erro = document.getElementById('cep-erro');
            erro.classList.remove('d-none');
        }
    } 
    else {
        limpaFormulario();
    }
};


// Ex: 3

    let scrollAtingiuFinal = false;

    function verificarPosicaoScroll() {
        let textarea = document.getElementById('termos-texto');
        let checkbox = document.getElementById('termos');

        if (textarea.scrollTop >= textarea.scrollHeight - textarea.offsetHeight - 10) {
            checkbox.disabled = false;
            textarea.classList.add('fim-scroll');
            scrollAtingiuFinal = true;
        } else if (scrollAtingiuFinal) {
            checkbox.disabled = false;
            textarea.classList.remove;
          } else {
            checkbox.disabled = true;
            textarea.classList.remove;
          }
    }

  let textarea = document.getElementById('termos-texto').addEventListener('scroll', verificarPosicaoScroll);


    // Validar campos para poder salvar

  function verificarCamposObrigatorios() {
    let formulario = document.getElementById('formulario');
    let camposObrigatorios = formulario.querySelectorAll('[required]');
  
    for (let i = 0; i < camposObrigatorios.length; i++) {
      if (!camposObrigatorios[i].value) {
        return false;
      }
    }
  
    return true;
  }

  
  function verificarCamposObrigatorios() {
    let formulario = document.getElementById('formulario');
    let camposObrigatorios = formulario.querySelectorAll('[required]');

    for (let i = 0; i < camposObrigatorios.length; i++) {
      if (!camposObrigatorios[i].value) {
        return false;
      }
    }

    return true;
  }

  function habilitarSalvar() {
    let checkbox = document.getElementById('termos');
    let salvar = document.getElementById('salvar');

    if (checkbox.checked && verificarCamposObrigatorios()) {
      salvar.disabled = false;
    } else {
      salvar.disabled = true;
    }
  }

  function exibirDados() {
    if (!verificarCamposObrigatorios()) {
      alert('Preencha todos os campos obrigatórios!');
      return;
    }

    let dadosFormulario = {
      't-nome': document.getElementById('nome').value,
      't-sobrenome': document.getElementById('sobrenome').value,
      't-email': document.getElementById('email').value,
      't-login': document.getElementById('login').value,
      't-senha': document.getElementById('senha').value,
      't-cep': document.getElementById('cep').value,
      't-endereco': document.getElementById('endereco').value,
      't-complemento': document.getElementById('complemento').value,
      't-bairro': document.getElementById('bairro').value,
      't-cidade': document.getElementById('cidade').value,
      't-estado': document.getElementById('estado').value,
      't-github': document.getElementById('github').value,
      't-academia': document.getElementById('academia').options[document.getElementById('academia').selectedIndex].text,
      't-professor': document.getElementById('professor').options[document.getElementById('professor').selectedIndex].text,
      't-termos': document.getElementById('termos').checked ? 'Aceito' : 'Não aceito',
      't-info': document.getElementById('info-sim').checked ? 'Sim' : 'Não'
    };

    for (let key in dadosFormulario) {
      document.getElementById(key).textContent = dadosFormulario[key];
    }

    let tabelaDados = document.getElementById('tabela-dados');
    tabelaDados.classList.remove('d-none');

    // Redirecionar para a tabela
    window.location.href = '#tabela-dados';
  }

  document.getElementById('termos').addEventListener('change', habilitarSalvar);
  document.getElementById('formulario').addEventListener('input', habilitarSalvar);
  document.getElementById('formulario').addEventListener('submit', function(event) {
    event.preventDefault();
    exibirDados();
  });
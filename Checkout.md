# Eclipse e SDK #

Siga as instruções em https://developers.google.com/eclipse/docs/download

# Instalando o Subversive #

Execute os seguintes passos no Eclipse:
  1. Vá em Help -> Install New Software.
  1. No campo "Work with:", escolha o repositório da sua versáo do Eclipse (Kepler, Galileo, etc). É uma URL do tipo "http://download.eclipse.org/releases/-versao-".
  1. Depois que aparecerem as opções de software disponível, procure o Subversive dentro do item "Collaboration", ou vá no campo de busca e digite "svn".
  1. Marque "Subversive SVN Team Provider"
  1. Vá clicando em next, finish, etc. O Eclipse será reiniciado.

# Instalando o Conector #

Normalmente, quando depois que reiniciar o Eclipse, aparece uma tela para escolher qual o conector SVN que será usado com o Subversive. Caso isso não aconteça, siga os passos a seguir:

  1. Vá em Help -> Install New Software.
  1. No campo "Work with:", escolha o repositório "http://community.polarion.com/projects/subversive/download/eclipse/3.0/kepler-site/". Se ele não existir, basta digitar ele no campo "Work With".
  1. Dentro de "Subversive SVN Connectors", escolha um conector adequado a sua plataforma. No windows eu recomento o JavaHL Binaries, de 32-bits ou 64-bits (dependendo de qual versão do ECLIPSE estiver em uso, na dúvida veja em Help -> About Eclipse).
  1. Vá clicando em next, finish, etc. O Eclipse será reiniciado.

# Adicionando o projeto ao seu workspace #

  1. Vá em File -> New -> Other
  1. Escolha SVN -> Project from SVN
  1. Caso seja seu primeiro projeto SVN, pule para a próxima etapa, senão, escolha "Create a new repository location".
  1. No formulário "Enter Repository Location Information", no campo URL digite "https://lasthope.googlecode.com/svn". Em Authentication, insira seu e-mail e na senha, insira sua senha do Google Code (senha disponível em https://code.google.com/hosting/settings). Se quiser, coloque um label no repositório. Clique em Next e depois Finish.
  1. No formulário "Check Out As", marque a opção "Find projects in the children of the selected source", e clique em Finish.
  1. No furmulário "Selected project will be..." clique em Finish também.
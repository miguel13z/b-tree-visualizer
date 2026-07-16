import Layout from "../../components/Layout/Layout";
import tree1 from "../../../public/arvore1.png";

import "./About.css";

function About() {
  return (
    <Layout>
      <div className="about-container">
        <h1>B-Tree Visualizer</h1>
        <p>
          O B-Tree Visualizer é uma ferramenta web com o objetivo de visualizar
          os principais algoritmos por trás das operações básicas (inserção,
          remoção e busca) nas árvores B.
        </p>
        <hr />
        <br />
        <h1>Um pouco sobre as Árvores B</h1>
        <h2>1. Características</h2>
        <ul>
          <li>
            É uma estrutura de dados <strong>balanceada</strong>, na qual todas
            as folhas se encontram no último nível.
          </li>
          <li>
            É definida por uma <strong>ordem</strong>, que estabelece o número
            máximo de filhos que cada nó pode possuir.
          </li>
          <li>
            Seus nós são chamados de <strong>páginas</strong>.
          </li>
          <li>
            Destaca-se pela capacidade de armazenar{" "}
            <strong>mais de um elemento simultaneamente</strong> dentro de um
            mesmo nó.
          </li>
        </ul>
        <p>
          No mundo real, as Árvores B são a base de muitos sistemas de banco de
          dados e sistemas de arquivos (como NTFS e ext4). Elas foram projetadas
          para funcionar de forma altamente otimizada em dispositivos de
          armazenamento de bloco (como discos rígidos), minimizando a quantidade
          de acessos à memória necessários para encontrar, ler ou gravar grandes
          volumes de informações.
        </p>

        <div className="btree-image-container">
          <img src={tree1} alt="Exemplo de Árvore B" className="btree-image" />
          <p className="btree-caption">
            Exemplo de Árvore B. Fonte: Elaborada pelos autores.
          </p>
        </div>

        <h2>2. Propriedades</h2>
        <p>
          Para garantir o seu balanceamento, uma árvore B de ordem{" "}
          <strong>m</strong> segue propriedades matemáticas rigorosas:
        </p>
        <ul>
          <li>
            <strong>Capacidade Máxima:</strong> Cada nó pode ter, no máximo,{" "}
            <em>m</em> filhos.
          </li>
          <li>
            <strong>Capacidade Mínima:</strong> Todos os nós (com exceção da
            raiz) devem ter, no mínimo, <em>m/2 - 1</em> filhos.
          </li>
          <li>
            <strong>Regra da Raiz:</strong> A raiz precisa ter pelo menos 2
            filhos, a menos que a árvore não possua filhos (sendo ela mesma uma
            folha).
          </li>
          <li>
            <strong>Nivelamento:</strong> Todas as folhas se encontram
            exatamente no mesmo nível.
          </li>
          <li>
            <strong>Relação Chaves e Filhos:</strong> Um nó interno que possui{" "}
            <em>k</em> filhos possuirá exatamente <em>k-1</em> chaves.
          </li>
          <li>
            <strong>Ordenação e Separação:</strong> As chaves de cada nó são
            armazenadas de forma estritamente ordenada e atuam diretamente como
            separadores, guiando a busca para os respectivos nós filhos.
          </li>
        </ul>
      </div>
    </Layout>
  );
}

export default About;

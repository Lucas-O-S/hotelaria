document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("addQuartoBtn").addEventListener("click", function () {
        const dataCheckIn = document.getElementById("dataCheckIn").value;
        const dataCheckOut = document.getElementById("dataCheckOut").value;

        if (!dataCheckIn || !dataCheckOut) {
            alert("Por favor, insira as datas de Check-In e Check-Out.");
            return;
        }

        const url = `/hotelaria-ibmec/quarto/disponiveis?dataCheckIn=${encodeURIComponent(dataCheckIn)}&dataCheckOut=${encodeURIComponent(dataCheckOut)}`;
        console.log(`URL gerada: ${url}`);

        fetch(url)
            .then(response => {
                console.log('Status da resposta:', response.status);
                return response.text().then(text => {
                    try {
                        return JSON.parse(text);
                    } catch (error) {
                        console.error('Erro ao parsear JSON:', error);
                        console.log('Resposta do servidor:', text);
                        throw new Error('Erro ao parsear JSON');
                    }
                });
            })
            .then(quartos => {
                console.log(`Dados recebidos: ${JSON.stringify(quartos)}`);

                const container = document.getElementById('quartos-container');
                container.innerHTML = ""; // Clear the container before adding new options

                if (quartos.length === 0) {
                    alert('Nenhum quarto disponível encontrado.');
                    return;
                }

                quartos.forEach((quarto, index) => {
                    const row = document.createElement('div');
                    row.className = 'form-row align-items-end mb-3';

                    const col = document.createElement('div');
                    col.className = 'col';

                    const formGroup = document.createElement('div');
                    formGroup.className = 'form-group';

                    const label = document.createElement('label');
                    label.htmlFor = `quarto-${index}`;
                    label.innerText = 'Quarto';

                    const select = document.createElement('select');
                    select.className = 'form-control';
                    select.id = `quarto-${index}`;
                    select.name = `quartos[${index}].idQuarto`;
                    select.required = true;

                    const defaultOption = document.createElement('option');
                    defaultOption.value = "";
                    defaultOption.disabled = true;
                    defaultOption.selected = true;
                    defaultOption.innerText = 'Escolha o Quarto';

                    select.appendChild(defaultOption);

                    // Populando opções da lista de quartos
                    quartos.forEach(quarto => {
                        const option = document.createElement('option');
                        option.value = quarto.idQuarto;
                        option.text = `${quarto.numero} - ${quarto.nome}`;
                        select.appendChild(option);
                    });

                    formGroup.appendChild(label);
                    formGroup.appendChild(select);
                    col.appendChild(formGroup);

                    const colAuto = document.createElement('div');
                    colAuto.className = 'col-auto';

                    const button = document.createElement('button');
                    button.type = 'button';
                    button.className = 'btn btn-danger';
                    button.innerText = 'Remover';
                    button.onclick = () => row.remove();

                    colAuto.appendChild(button);

                    row.appendChild(col);
                    row.appendChild(colAuto);

                    container.appendChild(row);
                });
            })
            .catch(error => {
                console.error('Erro ao verificar disponibilidade:', error);
                alert('Erro ao verificar disponibilidade dos quartos. Verifique os logs para mais detalhes.');
            });
    });
});

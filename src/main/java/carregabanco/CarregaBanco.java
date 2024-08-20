package carregabanco;

import carregabanco.model.AlunoModel;
import carregabanco.model.ServidorModel;
import carregabanco.repository.AlunoDao;
import carregabanco.repository.ServidorDao;
import carregabanco.view.CarregaBancoView;

public class CarregaBanco {
	public static void main(String[] args) {
//		new AlunoView();
//		new ServidorView();
		new CarregaBancoView();
		AlunoModel alunoModel = AlunoDao.getInstance().getById(1);
		ServidorModel servidorModel = ServidorDao.getInstance().getById(1);
	}
}
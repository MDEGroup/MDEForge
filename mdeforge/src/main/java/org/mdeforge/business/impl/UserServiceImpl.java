package org.mdeforge.business.impl;

import java.util.List;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Role;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.VerificationToken;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.ProjectRepository;
import org.mdeforge.integration.RoleRepository;
import org.mdeforge.integration.UserRepository;
import org.mdeforge.integration.VerificationTokenRepository;
import org.mdeforge.integration.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	protected SimpleMongoDbFactory mongoDbFactory;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ArtifactRepository artifactRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private WorkspaceRepository workspaceRepository;
	@Autowired
	private VerificationTokenRepository verificationTokentRepository;
	@Override
	public User authenticate(String username) throws BusinessException {
		return userRepository.findByUsernameAndEnabled(username, true);
	}

	@Override
	public User create(User user) throws BusinessException {
		Role role = roleRepository.findOne("546f7ba5ce248eba4487eda5");
		user.getRoles().add(role);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userRepository.save(user);
	}
	@Override
	public List<User> findByUsernameContaining(String name) {
		return userRepository.findByUsernameContaining(name);
	}
	
	@Override
	public User findOne(String id) throws BusinessException{
		User u = userRepository.findOne(id);
		if(u == null)
			throw new  BusinessException();
		else return u;
	}
	@Override
	public User findOneByUsername(String username) throws BusinessException{
		User u = userRepository.findByUsername(username);
		return u;
	}
	@Override
	public User findOneByEmail(String email) throws BusinessException{
		User u = userRepository.findByEmail(email);
		return u;
	}
	@Override
	public List<User> findAll() throws BusinessException {
		return userRepository.findAll();
	}

	@Override
	public void delete(String id) throws BusinessException {
		try{
			User user = userRepository.findOne(id);
			if(!user.getOwner().isEmpty())
				throw new BusinessException("User has own artifacts");
			for(Artifact art : user.getSharedArtifact()){
				art.getShared().remove(user);
				artifactRepository.save(art);
			}
			for(Project project : user.getSharedProject()){
				project.getUsers().remove(user);
				projectRepository.save(project);
			}
			workspaceRepository.delete(user.getWorkspaces());
			userRepository.delete(user);
		}catch(Exception e) {throw new BusinessException();}
	}



	@Override
	public long countUsers() throws BusinessException {
		return userRepository.count();
	}

	@Override
	public void saveRegisteredUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public VerificationToken getVerificationToken(String token) {
		return verificationTokentRepository.findByToken(token);
	}

	@Override
	public void createVerificationToken(User user, String token) {
		Role role = roleRepository.findOne("546f7ba5ce248eba4487eda5");
		user.getRoles().add(role);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user = userRepository.save(user);
		VerificationToken vt = new VerificationToken(token, user);
		verificationTokentRepository.save(vt);
	}

	@Override
	public void update(User user) throws BusinessException{
		User u = userRepository.findOne(user.getId());
		u.setEmail(user.getEmail());
		u.setImage((user.getImage() == null)?
				u.getImage():
					user.getImage());
		u.setFirstname(user.getFirstname());
		u.setLastname(user.getLastname());
		userRepository.save(u);
	}

	@Override
	public void changePassword(User us, String password_old, String password_new, String password_new_r)
			throws BusinessException {
		if (!password_new.equals(password_new_r)) throw new BusinessException("New pw is different to retyped pw");
		String bcrypt = new BCryptPasswordEncoder().encode(password_new);
		if (us.getPassword().equals(bcrypt)) throw new BusinessException("Old password is wrong");
		User u = userRepository.findOne(us.getId());
		u.setPassword(bcrypt);
		userRepository.save(u);
		
	}

	@Override
	public void removeSharedProjectInUsers(Project p) throws BusinessException {
		// TODO Auto-generated method stub
			
		userRepository.findAll().forEach(user ->{
			user.getSharedProject().remove(p);
			userRepository.save(user);
		});
		
	}

}

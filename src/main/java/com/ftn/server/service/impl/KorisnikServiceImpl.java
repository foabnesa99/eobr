package com.ftn.server.service.impl;

import com.ftn.server.model.Korisnik;
import com.ftn.server.model.dto.korisnik.KorisnikCreateRequest;
import com.ftn.server.model.dto.korisnik.KorisnikMapper;
import com.ftn.server.model.dto.korisnik.KorisnikUpdateRequest;
import com.ftn.server.repository.KorisnikRepository;
import com.ftn.server.security.ContextService;
import com.ftn.server.service.KorisnikService;
import com.ftn.server.util.exceptions.KorisnikMissingException;
import com.ftn.server.util.exceptions.NotAuthorizedException;
import com.ftn.server.util.exceptions.UsernameExistsException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
@Transactional
@Service
@AllArgsConstructor
public class KorisnikServiceImpl implements KorisnikService{

    private final KorisnikRepository korisnikRepository;

    @Override
    public Korisnik getKorisnikByUsername(String username) {
        return korisnikRepository.findKorisnikByKorisnickoIme(username);
    }
    @Override
    public Korisnik getKorisnikByUsernameRequired(String username){
        Korisnik userByUsername = getKorisnikByUsername(username);
        if (userByUsername == null) throw new KorisnikMissingException();
        return userByUsername;
    }

    @Override
    public Korisnik fetchLoggedUser() {
        if (ContextService.getLoggedUser().isPresent()) {
            return getKorisnikByUsernameRequired(ContextService.getLoggedUser().get().getKorisnickoIme());
        } else throw new NotAuthorizedException("Ne postoji trenutno ulogovani korisnik");
    }
    @Override
    public Korisnik addUser(KorisnikCreateRequest request) {
        if (getKorisnikByUsername(request.getKorisnickoIme()) != null) {
            throw new UsernameExistsException();
        }
        final Korisnik user = KorisnikMapper.INSTANCE.fromCreateDto(request);

        return korisnikRepository.save(user);
    }
    @Override
    public Korisnik updateUser(Long id, @Valid KorisnikUpdateRequest updateRequest) {
        Korisnik userById = getUserById(id);
        userById.setIme(updateRequest.getIme());
        if (StringUtils.hasText(updateRequest.getKorisnickoIme()))
            userById.setKorisnickoIme(updateRequest.getKorisnickoIme());
        // current user cannot change own roles
        Korisnik loggedUser = fetchLoggedUser();
//        if (!Objects.equals(loggedUser.getId(), id)) {
//            if (!CollectionUtils.isEmpty(updateRequest.getRole())) {
//                userById.getRoles().clear();
//                userById.getRoles().addAll(updateRequest.getRoles());
//            }
//        }
        korisnikRepository.save(userById);
        return userById;
    }

//    public User updateUserProfile(@Valid UserProfileSettingsRequest profileSettingsRequest) {
//        User currentUser = getUserById(profileSettingsRequest.getId());
//        if (StringUtils.hasText(profileSettingsRequest.getName())) {
//            currentUser.setName(profileSettingsRequest.getName());
//        }
//        if (StringUtils.hasText(profileSettingsRequest.getPhone())) {
//            currentUser.setPhone(profileSettingsRequest.getPhone());
//        }
//        if (StringUtils.hasText(profileSettingsRequest.getEmail())) {
//            currentUser.setEmail(profileSettingsRequest.getEmail());
//        }
//        if (StringUtils.hasText(profileSettingsRequest.getNewPassword()) && StringUtils.hasText(profileSettingsRequest.getCurrentPassword()) && StringUtils.hasText(profileSettingsRequest.getConfirmPassword())) {
//            updatePassword(new UpdatePasswordRequest(currentUser.getEmail(), profileSettingsRequest.getCurrentPassword(), profileSettingsRequest.getNewPassword(), profileSettingsRequest.getConfirmPassword()));
//        }
//        return userRepository.save(currentUser);
//    }
    @Override
    public List<Korisnik> fetchAllActive() {
        return korisnikRepository.findAllByActiveIsTrueAndDeletedIsFalse();
    }
    @Override
    public void enableUser(@Valid Long id) {
        Korisnik user = getUserById(id);
        if (!user.isActive()) {
            user.setActive(true);
//			user.setStatus(UserStatus.ACTIVE);
            korisnikRepository.save(user);
        }
    }
    @Override
    public void disableUser(@Valid Long id) {
        Korisnik user = getUserById(id);
        if (user.isActive()) {
            user.setActive(false);
//			user.setStatus(UserStatus.INACTIVE);
            korisnikRepository.save(user);
        }
    }
    @Override
    public void deleteUser(@Valid Long id) {
        Korisnik user = getUserById(id);
        Korisnik loggedUser = fetchLoggedUser();
        if (!Objects.equals(loggedUser, user)) {
            user.setDeleted(true);
            korisnikRepository.save(user);
        }
    }

//    public Page<User> listUsers(UserListRequest request) {
//        return userRepository.findAll(request.predicate(), request.pageable());
//    }
//
//    public void createPassword(CreatePasswordRequest createPasswordRequest) {
//        String password = createPasswordRequest.getPassword();
//        String repeatPassword = createPasswordRequest.getConfirmedPassword();
//        if (!Objects.equals(password, repeatPassword)) {
//            throw new PasswordsDoesntException("Passwords doesn't match");
//        }
//        User user = userRepository.findOneByEmail(createPasswordRequest.getEmail());
//        if (user.getPasswordRecoveryKey() == null) {
//            throw new ValidationException("Key doesn't match");
//        }
//        if (!Objects.equals(createPasswordRequest.getKey(), user.getPasswordRecoveryKey())) {
//            throw new ValidationException("Key doesn't match");
//        }
//        if (user.getPasswordRecoveryTime() == null) {
//            throw new ValidationException("Time expired");
//        }
//        if (System.currentTimeMillis() > user.getPasswordRecoveryTime()) {
//            throw new ValidationException("Time expired");
//        }
//        user.setPassword(passwordEncoder.encode(password));
//        user.setPasswordRecoveryKey(null);
//        user.setPasswordRecoveryTime(null);
//        user.setStatus(UserStatus.ACTIVE);
//        userRepository.save(user);
//    }
//
//    public void forgotPassword(ForgotPasswordRequest forgotPasswordRequest) {
//        User user = getUserByUsernameRequired(forgotPasswordRequest.getEmail());
//        String key = UUID.randomUUID().toString();
//        Long passwordRecoveryTime = calculatePasswordRecoveryTime();
//        user.setPasswordRecoveryKey(key);
//        user.setPasswordRecoveryTime(passwordRecoveryTime);
//        final User savedUser = userRepository.save(user);
//        mailService.sendForgotPasswordEmail(savedUser);
//    }
//
//    private long calculatePasswordRecoveryTime() {
//        return System.currentTimeMillis() + recoverPasswordMaxTime;
//    }
//
//    public void updatePassword(UpdatePasswordRequest updatePasswordRequest) {
//        User user = fetchLoggedUser();
//        String oldPassword = updatePasswordRequest.getOldPassword();
//        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
//            throw new InvalidPasswordException("Bad password or username");
//        }
//        String password = updatePasswordRequest.getPassword();
//        String repeatPassword = updatePasswordRequest.getConfirmedPassword();
//        if (!Objects.equals(password, repeatPassword)) {
//            throw new PasswordsDoesntException("Passwords doesn't match");
//        }
//        user.setPassword(passwordEncoder.encode(password));
//        userRepository.save(user);
//    }
//
//    public void changePassword(String username, String oldPassword, String newPassword) throws NotAuthorizedException {
//        User user = getUserByUsernameRequired(username);
//        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
//            throw new InvalidPasswordException("Bad password or username");
//        }
//        user.setPassword(passwordEncoder.encode(newPassword));
//        userRepository.save(user);
//    }

    public Korisnik getUserById(Long id) {
        return korisnikRepository.findById(id)
            .orElseThrow(KorisnikMissingException::new);
    }

}
